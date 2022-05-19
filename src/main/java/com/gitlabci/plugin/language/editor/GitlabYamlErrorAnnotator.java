package com.gitlabci.plugin.language.editor;

import com.gitlabci.plugin.utils.PsiUtils;
import com.gitlabci.plugin.utils.Utils;
import com.gitlabci.plugin.language.GitlabYamlKeywords;
import com.gitlabci.plugin.language.psi.*;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class GitlabYamlErrorAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

        // annotate duplicates
        if (element instanceof GitlabYamlMapping) {
            boolean containsDuplicates = !Arrays
                    .stream(element.getChildren())
                    .filter(child -> child instanceof GitlabYamlPair)
                    .map(PsiUtils::getIdStr)
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
            if (element.getParent() instanceof GitlabYamlMapping && PsiUtils.getSuperParent(2, element) instanceof GitlabYamlPair) {
                parentPairId = PsiUtils.getSuperParent(2, element).getFirstChild();
                parentIdStr = parentPairId.getText().strip();
                annotateIncorrectInput(
                        parentIdStr,
                        idStr,
                        GitlabYamlKeywords.blockPossibleInputs,
                        element,
                        holder
                );
            }

            if (PsiUtils.getSuperParent(3, element) instanceof GitlabYamlSequence) {
                parentPairId = PsiUtils.getSuperParent(4, element).getFirstChild();
                parentIdStr = parentPairId.getText().strip();
                annotateIncorrectInput(
                        parentIdStr,
                        idStr,
                        GitlabYamlKeywords.sequencePossibleInputs,
                        element,
                        holder
                );
            }

            if (PsiUtils.getSuperParent(2, element) instanceof GitlabYamlTopLevelMapping) {
                if (GitlabYamlKeywords.keywordTypes.containsKey(idStr)) {
                    if (!GitlabYamlKeywords.topLevelKeywords.contains(idStr)) {
                        String message = String.format(
                                "Keyword %s is not allowed at the top level declaration. Possible inputs: %s",
                                idStr,
                                Utils.listToString(GitlabYamlKeywords.topLevelKeywords)
                        );
                        createAnnotation(
                                element,
                                holder,
                                message
                        );
                    }
                } else {
                    List<String> stages = PsiUtils.getStages(element.getParent());
                    if (stages == null && !PsiUtils.containsPredefinedStages(element.getParent())) {
                        String message = String.format(
                                "Neither user stages nor default stages defined. Please define at least one stage with 'stages' keyword or use next predefined stages: %s",
                                Utils.listToString(GitlabYamlKeywords.predefinedStages)
                        );

                        createAnnotation(
                                element,
                                holder,
                                message
                        );
                    }

                    if (stages != null && !stages.contains(PsiUtils.getValueOfKey("stage", element))) {
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

    private void annotateIncorrectInput(String key, String value, Map<String, List<String>> possibleInputs, PsiElement element, AnnotationHolder holder) {
        if (possibleInput(key, value, possibleInputs)) {
            String message = String.format(
                    "Incorrect input for keyword %s. Possible inputs: %s",
                    key,
                    Utils.listToString(possibleInputs.get(key))
            );

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

    private void createAnnotation(PsiElement element, AnnotationHolder holder, String message) {
        holder.newAnnotation(HighlightSeverity.ERROR, message)
                .range(element.getTextRange())
                .create();
    }
}
