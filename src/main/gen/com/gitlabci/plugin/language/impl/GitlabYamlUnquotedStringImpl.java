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

public class GitlabYamlUnquotedStringImpl extends ASTWrapperPsiElement implements GitlabYamlUnquotedString {

  public GitlabYamlUnquotedStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitlabYamlVisitor visitor) {
    visitor.visitUnquotedString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitlabYamlVisitor) accept((GitlabYamlVisitor)visitor);
    else super.accept(visitor);
  }

}
