// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.gitlabci.plugin.language.psi.*;

public class GitlabYamlArrayImpl extends ASTWrapperPsiElement implements GitlabYamlArray {

  public GitlabYamlArrayImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitlabYamlVisitor visitor) {
    visitor.visitArray(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitlabYamlVisitor) accept((GitlabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GitlabYamlLiteral> getLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GitlabYamlLiteral.class);
  }

}