// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gitlabci.plugin.language.psi.GitLabYamlTokenTypes.*;
import com.gitlabci.plugin.language.psi.*;

public class GitLabYamlIdentifierImpl extends GitLabYamlNamedElementImpl implements GitLabYamlIdentifier {

  public GitLabYamlIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitLabYamlVisitor visitor) {
    visitor.visitIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitLabYamlVisitor) accept((GitLabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getText() {
    return GitLabYamlPsiImplUtil.getText(this);
  }

  @Override
  public String getName() {
    return GitLabYamlPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return GitLabYamlPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return GitLabYamlPsiImplUtil.getNameIdentifier(this);
  }

}
