// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gitlabci.plugin.language.psi.GitLabYamlTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.gitlabci.plugin.language.psi.*;

public class GitLabYamlTopLevelMappingImpl extends ASTWrapperPsiElement implements GitLabYamlTopLevelMapping {

  public GitLabYamlTopLevelMappingImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitLabYamlVisitor visitor) {
    visitor.visitTopLevelMapping(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitLabYamlVisitor) accept((GitLabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GitLabYamlMapping getMapping() {
    return findNotNullChildByClass(GitLabYamlMapping.class);
  }

}
