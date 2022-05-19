package com.gitlabci.plugin.language.documentation;

import com.gitlabci.plugin.utils.Utils;
import com.gitlabci.plugin.language.GitlabYamlKeywords;
import com.gitlabci.plugin.language.psi.GitlabYamlIdentifier;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

import static com.gitlabci.plugin.language.documentation.GitlabYamlDocumentationBuilder.buildDoc;

public class GitlabYamlDocumentationProvider extends AbstractDocumentationProvider {
    @Override
    public @Nullable String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        if (element instanceof GitlabYamlIdentifier) {
            String idStr = element.getText().strip();
            String possibleInputs;
            if (GitlabYamlKeywords.blockPossibleInputs.containsKey(idStr)) {
                possibleInputs = Utils.listToString(GitlabYamlKeywords.blockPossibleInputs.get(idStr));
                return buildDoc(idStr, possibleInputs);
            } else if (GitlabYamlKeywords.inlinePossibleInputs.containsKey(element.getText())) {
                possibleInputs = Utils.listToString(GitlabYamlKeywords.inlinePossibleInputs.get(idStr));
                return buildDoc(idStr, possibleInputs);
            } else if (GitlabYamlKeywords.sequencePossibleInputs.containsKey(element.getText())) {
                possibleInputs = Utils.listToString(GitlabYamlKeywords.sequencePossibleInputs.get(idStr));
                return buildDoc(idStr, possibleInputs);
            } else if (GitlabYamlKeywords.keywordTypes.containsKey(idStr)) {
                return buildDoc(idStr, null);
            } else {
                return String.format("No documentation found for keyword '%s'", idStr);
            }
        }
        return null;
    }
}
