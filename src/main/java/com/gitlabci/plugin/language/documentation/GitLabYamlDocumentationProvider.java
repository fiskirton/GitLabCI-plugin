package com.gitlabci.plugin.language.documentation;

import com.gitlabci.plugin.language.GitLabYamlKeywords;
import com.gitlabci.plugin.language.psi.GitLabYamlIdentifier;
import com.gitlabci.plugin.utils.Utils;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

import static com.gitlabci.plugin.language.documentation.GitLabYamlDocumentationBuilder.buildDoc;

public class GitLabYamlDocumentationProvider extends AbstractDocumentationProvider {
    @Override
    public @Nullable String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        if (element instanceof GitLabYamlIdentifier) {
            String idStr = element.getText().strip();
            String possibleInputs;
            if (GitLabYamlKeywords.blockPossibleInputs.containsKey(idStr)) {
                possibleInputs = Utils.listToString(GitLabYamlKeywords.blockPossibleInputs.get(idStr));
                return buildDoc(idStr, possibleInputs);
            } else if (GitLabYamlKeywords.inlinePossibleInputs.containsKey(element.getText())) {
                possibleInputs = Utils.listToString(GitLabYamlKeywords.inlinePossibleInputs.get(idStr));
                return buildDoc(idStr, possibleInputs);
            } else if (GitLabYamlKeywords.sequencePossibleInputs.containsKey(element.getText())) {
                possibleInputs = Utils.listToString(GitLabYamlKeywords.sequencePossibleInputs.get(idStr));
                return buildDoc(idStr, possibleInputs);
            } else if (GitLabYamlKeywords.keywordTypes.containsKey(idStr)) {
                return buildDoc(idStr, null);
            } else {
                return String.format("No documentation found for keyword '%s'", idStr);
            }
        }
        return null;
    }
}
