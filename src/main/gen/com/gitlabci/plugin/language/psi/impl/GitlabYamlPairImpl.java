// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.gitlabci.plugin.language.psi.*;

public class GitlabYamlPairImpl extends ASTWrapperPsiElement implements GitlabYamlPair {

  public GitlabYamlPairImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GitlabYamlVisitor visitor) {
    visitor.visitPair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GitlabYamlVisitor) accept((GitlabYamlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GitlabYamlArray getArray() {
    return findChildByClass(GitlabYamlArray.class);
  }

  @Override
  @Nullable
  public GitlabYamlBlockEnd getBlockEnd() {
    return findChildByClass(GitlabYamlBlockEnd.class);
  }

  @Override
  @Nullable
  public GitlabYamlColonSeparated getColonSeparated() {
    return findChildByClass(GitlabYamlColonSeparated.class);
  }

  @Override
  @Nullable
  public GitlabYamlEndOfLine getEndOfLine() {
    return findChildByClass(GitlabYamlEndOfLine.class);
  }

  @Override
  @NotNull
  public GitlabYamlIdentifier getIdentifier() {
    return findNotNullChildByClass(GitlabYamlIdentifier.class);
  }

  @Override
  @Nullable
  public GitlabYamlLiteral getLiteral() {
    return findChildByClass(GitlabYamlLiteral.class);
  }

  @Override
  @Nullable
  public GitlabYamlMapping getMapping() {
    return findChildByClass(GitlabYamlMapping.class);
  }

  @Override
  @Nullable
  public GitlabYamlSequence getSequence() {
    return findChildByClass(GitlabYamlSequence.class);
  }

  @Override
  @Nullable
  public GitlabYamlUnquotedString getUnquotedString() {
    return findChildByClass(GitlabYamlUnquotedString.class);
  }

}
