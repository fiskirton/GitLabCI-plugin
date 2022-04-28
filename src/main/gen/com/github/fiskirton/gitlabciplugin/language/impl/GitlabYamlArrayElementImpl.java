// This is a generated file. Not intended for manual editing.
package com.github.fiskirton.gitlabciplugin.language.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.fiskirton.gitlabciplugin.language.psi.GitlabYamlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.fiskirton.gitlabciplugin.language.psi.*;

public class GitlabYamlArrayElementImpl extends ASTWrapperPsiElement implements GitlabYamlArrayElement {

  public GitlabYamlArrayElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitlabYamlVisitor visitor) {
    visitor.visitArrayElement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitlabYamlVisitor) accept((GitlabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GitlabYamlInlineExpr getInlineExpr() {
    return findChildByClass(GitlabYamlInlineExpr.class);
  }

  @Override
  @NotNull
  public List<GitlabYamlKey> getKeyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GitlabYamlKey.class);
  }

}
