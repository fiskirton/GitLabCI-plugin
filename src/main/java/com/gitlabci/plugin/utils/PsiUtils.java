package com.gitlabci.plugin.utils;

import com.gitlabci.plugin.language.GitlabYamlKeywords;
import com.gitlabci.plugin.language.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PsiUtils {
    public static List<String> getStages(PsiElement element) {
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

    public static boolean containsPredefinedStages(PsiElement element) {
        return Arrays
                .stream(element.getChildren()).anyMatch(child -> child instanceof GitlabYamlPair && GitlabYamlKeywords.predefinedStages.contains(PsiUtils.getIdStr(child)));
    }

    public static String getValueOfKey(String key, PsiElement element) {
        PsiElement mapping = PsiTreeUtil.findChildOfType(element, GitlabYamlMapping.class);
        if (mapping != null) {
            PsiElement keyValuePair = Arrays
                    .stream(mapping.getChildren())
                    .filter(child -> child instanceof GitlabYamlPair && PsiUtils.getIdStr(child).equals(key))
                    .reduce((first, second) -> first).orElse(null);

            if (keyValuePair == null) {
                return null;
            }

            if (keyValuePair.getLastChild() instanceof GitlabYamlLiteral) {
                return keyValuePair.getLastChild().getText().strip();
            } else if (keyValuePair.getLastChild().getPrevSibling() instanceof GitlabYamlSequence) {
                PsiElement sequence = keyValuePair.getLastChild().getPrevSibling();
                StringBuilder value = new StringBuilder();
                for (var child : sequence.getChildren()) {
                    if (child instanceof GitlabYamlSequenceItem) {
                        value.append(child.getLastChild().getText().strip());
                        value.append("\n");
                    }
                }
                return value.toString();
            } else return null;
        } else return null;
    }

    public static String getIdStr(PsiElement element) {
        return element.getFirstChild().getText().strip();
    }

    public static PsiElement getSuperParent(int depth, PsiElement element) {
        if (depth == 0) {
            return element;
        }

        return getSuperParent(depth - 1, element.getParent());
    }


}
