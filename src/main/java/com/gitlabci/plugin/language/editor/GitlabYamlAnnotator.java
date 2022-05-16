package com.gitlabci.plugin.language.editor;

import com.gitlabci.plugin.language.completion.GitlabYamlKeywords;
import com.gitlabci.plugin.language.psi.*;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class GitlabYamlAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

        // annotate duplicates
        if (element instanceof GitlabYamlMapping) {
            boolean containsDuplicates = !Arrays
                    .stream(element.getChildren())
                    .filter(child -> child instanceof GitlabYamlPair)
                    .map(this::getIdStr)
                    .allMatch(new HashSet<>()::add);

            if (containsDuplicates) {
                String message = "There are duplicates in the mapping definition.";

                createAnnotation(
                        element,
                        holder,
                        message
                );
            }
        }

        // annotate incorrect definitions
        if (element instanceof GitlabYamlPair) {
            // Id is always the first child of pair
            PsiElement parentPairId;
            PsiElement id = element.getFirstChild();
            String idStr = id.getText().strip();
            String parentIdStr;
            if (element.getLastChild() instanceof GitlabYamlLiteral) {
                PsiElement ending = element.getLastChild();
                String endingStr = ending.getText().strip();
                if (possibleInput(idStr, endingStr, GitlabYamlKeywords.inlinePossibleInputs)) {
                    annotateIncorrectInput(
                            idStr,
                            endingStr,
                            GitlabYamlKeywords.inlinePossibleInputs,
                            element,
                            holder
                    );
                }
            }
            if (element.getParent() instanceof GitlabYamlMapping && getSuperParent(2, element) instanceof GitlabYamlPair) {
                parentPairId = getSuperParent(2, element).getFirstChild();
                parentIdStr = parentPairId.getText().strip();
                annotateIncorrectInput(
                        parentIdStr,
                        idStr,
                        GitlabYamlKeywords.blockPossibleInputs,
                        element,
                        holder
                );
            }

            if (getSuperParent(3, element) instanceof GitlabYamlSequence) {
                parentPairId = getSuperParent(4, element).getFirstChild();
                parentIdStr = parentPairId.getText().strip();
                annotateIncorrectInput(
                        parentIdStr,
                        id.getText().strip(),
                        GitlabYamlKeywords.sequencePossibleInputs,
                        element,
                        holder
                );
            }

            if (getSuperParent(2, element) instanceof GitlabYamlTopLevelMapping) {
                if (GitlabYamlKeywords.keywordTypes.containsKey(idStr)) {
                    if (!GitlabYamlKeywords.topLevelKeywords.contains(idStr)) {
                        String message = String.format(
                                "Keyword %s is not allowed at the top level declaration. Possible inputs: %s",
                                idStr,
                                getPossibleInputsFormatted(GitlabYamlKeywords.topLevelKeywords)
                        );
                        createAnnotation(
                                element,
                                holder,
                                message
                        );
                    }
                } else {
                    List<String> stages = getStages(element.getParent());
                    if (stages == null && !containsPredefinedStages(element.getParent())) {
                        String message = String.format(
                                "Neither user stages nor default stages defined. Please define at least one stage with 'stages' keyword or use next predefined stages: %s",
                                getPossibleInputsFormatted(GitlabYamlKeywords.predefinedStages)
                        );

                        createAnnotation(
                                element,
                                holder,
                                message
                        );
                    }

                    if (stages != null && !stages.contains(getStageDefinition(element))) {
                        String message = "Invalid definition. Unknown keyword or undefined stage";

                        createAnnotation(
                                element,
                                holder,
                                message
                        );
                    }
                }
            }
        }
    }

    private String getStageDefinition(PsiElement element) {
        PsiElement mapping = PsiTreeUtil.findChildOfType(element, GitlabYamlMapping.class);
        if (mapping != null) {
            PsiElement stage = Arrays
                    .stream(mapping.getChildren())
                    .filter(child -> child instanceof GitlabYamlPair && getIdStr(child).equals("stage"))
                    .reduce((first, second) -> first).orElse(null);

            return stage != null ? stage.getLastChild().getText().strip() : null;
        } else return null;

    }

    private boolean containsPredefinedStages(PsiElement element) {
        return Arrays
                .stream(element.getChildren()).anyMatch(child -> child instanceof GitlabYamlPair && GitlabYamlKeywords.predefinedStages.contains(getIdStr(child)));
    }

    private List<String> getStages(PsiElement element) {
        PsiElement stages = Arrays
                .stream(element.getChildren())
                .filter(child -> child instanceof GitlabYamlPair && getIdStr(child).equals("stages"))
                .reduce((first, second) -> first).orElse(null);

        return stages == null
                ? null
                : PsiTreeUtil.findChildrenOfType(stages, GitlabYamlSequenceItem.class)
                .stream()
                .map(child -> child.getLastChild().getText().strip())
                .collect(Collectors.toList());
    }

    private void annotateIncorrectInput(String key, String value, Map<String, List<String>> possibleInputs, PsiElement element, AnnotationHolder holder) {

        String message = String.format(
                        "Incorrect input for keyword %s. Possible inputs: %s",
                        key,
                        getPossibleInputsFormatted(possibleInputs.get(key))
        );

        if (possibleInput(key, value, possibleInputs)) {
            createAnnotation(
                    element,
                    holder,
                    message
            );
        }
    }

    private boolean possibleInput(String key, String value, Map<String, List<String>> possibleInputs) {
        if (possibleInputs.containsKey(key)) {
            return !possibleInputs.get(key).contains(value);
        } else {
            return false;
        }
    }

    private String getPossibleInputsFormatted(List<String> possibleInputs) {
        return String.join(", ", possibleInputs);
    }

    private PsiElement getSuperParent(int depth, PsiElement element) {
        if (depth == 0) {
            return element;
        }

        return getSuperParent(depth - 1, element.getParent());
    }

    private String getIdStr(PsiElement element) {
        return element.getFirstChild().getText().strip();
    }

    private void createAnnotation(PsiElement element, AnnotationHolder holder, String message) {
        holder.newAnnotation(HighlightSeverity.ERROR, message)
                .range(element.getTextRange())
                .create();
    }
}
