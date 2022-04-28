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

public class GitlabYamlInlineExprImpl extends ASTWrapperPsiElement implements GitlabYamlInlineExpr {

  public GitlabYamlInlineExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitlabYamlVisitor visitor) {
    visitor.visitInlineExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitlabYamlVisitor) accept((GitlabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getInt() {
    return findChildByType(INT);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
