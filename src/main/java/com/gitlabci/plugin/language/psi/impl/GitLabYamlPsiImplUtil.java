package com.gitlabci.plugin.language.psi.impl;

import com.gitlabci.plugin.language.psi.GitLabYamlElementFactory;
import com.gitlabci.plugin.language.psi.GitLabYamlIdentifier;
import com.gitlabci.plugin.language.psi.GitLabYamlTokenTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;


public class GitLabYamlPsiImplUtil {
    // remove trailing whitespaces from ID element
    public static String getText(GitLabYamlIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(GitLabYamlTokenTypes.ID);
        return (idNode != null) ? idNode.getText().strip() : null;
    }

    public static String getName(GitLabYamlIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(GitLabYamlTokenTypes.ID);
        return (idNode != null) ? idNode.getText().strip() : null;
    }

    public static PsiElement setName(GitLabYamlIdentifier element, String newName) {
        ASTNode idLeaf = element.getNode().findChildByType(GitLabYamlTokenTypes.ID);
        if (idLeaf != null) {
            GitLabYamlIdentifier property =
                    GitLabYamlElementFactory.createProperty(element.getProject(), newName);
            ASTNode newIdLeaf = property.getFirstChild().getNode();
            element.getNode().replaceChild(idLeaf, newIdLeaf);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(GitLabYamlIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(GitLabYamlTokenTypes.ID);
        return (idNode != null) ? idNode.getPsi() : null;
    }
}
