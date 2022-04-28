// This is a generated file. Not intended for manual editing.
package com.github.fiskirton.gitlabciplugin.language.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.fiskirton.gitlabciplugin.language.psi.GitlabYamlTypes.*;
import com.github.fiskirton.gitlabciplugin.language.psi.*;

public class GitlabYamlArrayListBlockImpl extends GitlabYamlBlockImpl implements GitlabYamlArrayListBlock {

  public GitlabYamlArrayListBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GitlabYamlVisitor visitor) {
    visitor.visitArrayListBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitlabYamlVisitor) accept((GitlabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GitlabYamlArrayElement> getArrayElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GitlabYamlArrayElement.class);
  }

  @Override
  @NotNull
  public GitlabYamlKey getKey() {
    return findNotNullChildByClass(GitlabYamlKey.class);
  }

}
