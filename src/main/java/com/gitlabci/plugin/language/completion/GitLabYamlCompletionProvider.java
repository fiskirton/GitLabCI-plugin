package com.gitlabci.plugin.language.completion;

import com.gitlabci.plugin.language.GitLabYamlBundle;
import com.gitlabci.plugin.language.GitLabYamlKeywords;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.PrioritizedLookupElement;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import icons.GitLabYamlPluginIcons;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class GitLabYamlCompletionProvider extends CompletionProvider<CompletionParameters> {

    private final List<String> keywords;

    public GitLabYamlCompletionProvider(List<String> keywords) {
        this.keywords = keywords;
    }

    private LookupElement buildCustomSuggestion(String keyword) {
        LookupElementBuilder result = LookupElementBuilder.create(keyword);

        switch (GitLabYamlKeywords.keywordTypes.get(keyword)) {
            case "global":
                return PrioritizedLookupElement.withPriority(
                        result.bold()
                                .withIcon(GitLabYamlPluginIcons.GitLabYamlGlobalKeywordIcon)
                                .withTypeText(GitLabYamlBundle.message("keyword.type.gitlabyaml.global")),
                        1
                );
            case "job":
                return PrioritizedLookupElement.withPriority(
                        result.bold()
                                .withIcon(GitLabYamlPluginIcons.GitLabYamlJobKeywordIcon)
                                .withTypeText(GitLabYamlBundle.message("keyword.type.gitlabyaml.job")),
                        2
                );
            case "input":
                return PrioritizedLookupElement.withPriority(
                        result.bold()
                                .withIcon(GitLabYamlPluginIcons.GitLabYamlInputIcon)
                                .withTypeText(GitLabYamlBundle.message("keyword.type.gitlabyaml.input")),
                        3
                );
            default:
                return null;
        }
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        result.addAllElements(keywords.stream().map(this::buildCustomSuggestion).collect(Collectors.toList()));
    }


}
