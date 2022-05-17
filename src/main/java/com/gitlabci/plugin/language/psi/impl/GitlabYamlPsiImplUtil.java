package com.gitlabci.plugin.language.psi.impl;

import com.gitlabci.plugin.language.psi.GitlabYamlElementFactory;
import com.gitlabci.plugin.language.psi.GitlabYamlIdentifier;
import com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;


public class GitlabYamlPsiImplUtil {
    // remove trailing whitespaces from ID element
    public static String getText(GitlabYamlIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(GitlabYamlTokenTypes.ID);
        return (idNode != null) ? idNode.getText().strip() : null;
    }

    public static String getName(GitlabYamlIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(GitlabYamlTokenTypes.ID);
        return (idNode != null) ? idNode.getText().strip() : null;
    }

    public static PsiElement setName(GitlabYamlIdentifier element, String newName) {
        ASTNode idLeaf = element.getNode().findChildByType(GitlabYamlTokenTypes.ID);
        if (idLeaf != null) {
            GitlabYamlIdentifier property =
                    GitlabYamlElementFactory.createProperty(element.getProject(), newName);
            ASTNode newIdLeaf = property.getFirstChild().getNode();
            element.getNode().replaceChild(idLeaf, newIdLeaf);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(GitlabYamlIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(GitlabYamlTokenTypes.ID);
        return (idNode != null) ? idNode.getPsi() : null;
    }

//    public static PsiElement setName(GitlabYamlProperty element, String name) {
//        PsiElement  e = GitlabYamlElementTextFactory.createStatementFromText(element.project, name);
//        PsiElement newE = PsiTreeUtil.findChildOfType(e, GitlabYamlProperty.class);
//        if (newE != null) {
//            e.replace(newE);
//        }
//        return e;
//    }
}
