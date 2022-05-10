package com.gitlabci.plugin.language.psi.impl;

import com.gitlabci.plugin.language.psi.GitlabYamlIdentifier;
import com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes;
import com.intellij.lang.ASTNode;


public class GitlabYamlPsiImplUtil {
    // remove trailing whitespaces from ID element
    public static String getText(GitlabYamlIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(GitlabYamlTokenTypes.ID);
        System.out.println("Node text: " + "'" + ((idNode != null) ? idNode.getText().strip() : "NOTHING") + "'");
        return (idNode != null) ? idNode.getText().strip() : null;
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
