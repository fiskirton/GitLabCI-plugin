// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes.*;
import com.gitlabci.plugin.language.psi.*;

public class GitlabYamlIdentifierImpl extends GitlabYamlNamedElementImpl implements GitlabYamlIdentifier {

  public GitlabYamlIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitlabYamlVisitor visitor) {
    visitor.visitIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitlabYamlVisitor) accept((GitlabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getText() {
    return GitlabYamlPsiImplUtil.getText(this);
  }

  @Override
  public String getName() {
    return GitlabYamlPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return GitlabYamlPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return GitlabYamlPsiImplUtil.getNameIdentifier(this);
  }

}
