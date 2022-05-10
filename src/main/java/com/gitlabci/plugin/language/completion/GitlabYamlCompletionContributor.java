package com.gitlabci.plugin.language.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.ElementPattern;
import com.intellij.psi.PsiElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GitlabYamlCompletionContributor extends CompletionContributor {
    private void extendWrapper(ElementPattern<PsiElement> pattern, List<String> keywordsGroup) {
        extend(CompletionType.BASIC, pattern, new GitlabYamlCompletionProvider(keywordsGroup));
    }

    private void applyPatternForKeywordsGroup(GitlabYamlPatterns.PossibleInputsPattern pattern, Map<String, List<String>> keywordsGroup) {
        for (var keywordsPossibleInputs : keywordsGroup.entrySet()) {
            extendWrapper(
                pattern.matchPattern(keywordsPossibleInputs.getKey()),
                keywordsPossibleInputs.getValue()
            );
        }
    }

    public GitlabYamlCompletionContributor() {
        extendWrapper(
            GitlabYamlPatterns.TopLevelKeywordsPatterns.topLevelKeywordsPattern(),
            GitlabYamlKeywords.keywordTypes.entrySet()
                    .stream()
                    .filter((entry) -> entry.getValue().equals("global") || entry.getValue().equals("job"))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList())
        );

        applyPatternForKeywordsGroup(
                GitlabYamlPatterns.PossibleInputsPatterns.afterIndentPossibleInputsPattern,
                GitlabYamlKeywords.blockPossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitlabYamlPatterns.PossibleInputsPatterns.afterDedentPossibleInputsPattern,
                GitlabYamlKeywords.blockPossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitlabYamlPatterns.PossibleInputsPatterns.afterPairPossibleInputsPattern,
                GitlabYamlKeywords.blockPossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitlabYamlPatterns.PossibleInputsPatterns.startMultiplePossibleInputsPattern,
                GitlabYamlKeywords.sequencePossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitlabYamlPatterns.PossibleInputsPatterns.continueMultiplePossibleInputsPattern,
                GitlabYamlKeywords.sequencePossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitlabYamlPatterns.PossibleInputsPatterns.inlineExprPossibleInputsPattern,
                GitlabYamlKeywords.inlinePossibleInputs
        );

    }
}
