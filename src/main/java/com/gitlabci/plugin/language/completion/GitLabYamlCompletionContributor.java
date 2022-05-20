package com.gitlabci.plugin.language.completion;

import com.gitlabci.plugin.language.GitLabYamlKeywords;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.ElementPattern;
import com.intellij.psi.PsiElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GitLabYamlCompletionContributor extends CompletionContributor {
    private void extendWrapper(ElementPattern<PsiElement> pattern, List<String> keywordsGroup) {
        extend(CompletionType.BASIC, pattern, new GitLabYamlCompletionProvider(keywordsGroup));
    }

    private void applyPatternForKeywordsGroup(GitLabYamlPatterns.PossibleInputsPattern pattern, Map<String, List<String>> keywordsGroup) {
        for (var keywordsPossibleInputs : keywordsGroup.entrySet()) {
            extendWrapper(
                pattern.matchPattern(keywordsPossibleInputs.getKey()),
                keywordsPossibleInputs.getValue()
            );
        }
    }

    public GitLabYamlCompletionContributor() {
        extendWrapper(
            GitLabYamlPatterns.TopLevelKeywordsPatterns.topLevelKeywordsPattern(),
            GitLabYamlKeywords.keywordTypes.entrySet()
                    .stream()
                    .filter((entry) -> entry.getValue().equals("global") || entry.getValue().equals("job"))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList())
        );

        applyPatternForKeywordsGroup(
                GitLabYamlPatterns.PossibleInputsPatterns.afterIndentPossibleInputsPattern,
                GitLabYamlKeywords.blockPossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitLabYamlPatterns.PossibleInputsPatterns.afterDedentPossibleInputsPattern,
                GitLabYamlKeywords.blockPossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitLabYamlPatterns.PossibleInputsPatterns.afterPairPossibleInputsPattern,
                GitLabYamlKeywords.blockPossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitLabYamlPatterns.PossibleInputsPatterns.startMultiplePossibleInputsPattern,
                GitLabYamlKeywords.sequencePossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitLabYamlPatterns.PossibleInputsPatterns.continueMultiplePossibleInputsPattern,
                GitLabYamlKeywords.sequencePossibleInputs
        );

        applyPatternForKeywordsGroup(
                GitLabYamlPatterns.PossibleInputsPatterns.inlineExprPossibleInputsPattern,
                GitLabYamlKeywords.inlinePossibleInputs
        );

    }
}
