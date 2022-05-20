// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class GitLabYamlVisitor extends PsiElementVisitor {

  public void visitArray(@NotNull GitLabYamlArray o) {
    visitPsiElement(o);
  }

  public void visitBlockEnd(@NotNull GitLabYamlBlockEnd o) {
    visitPsiElement(o);
  }

  public void visitEndOfLine(@NotNull GitLabYamlEndOfLine o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull GitLabYamlIdentifier o) {
    visitNamedElement(o);
  }

  public void visitLiteral(@NotNull GitLabYamlLiteral o) {
    visitPsiElement(o);
  }

  public void visitMapping(@NotNull GitLabYamlMapping o) {
    visitPsiElement(o);
  }

  public void visitPair(@NotNull GitLabYamlPair o) {
    visitPsiElement(o);
  }

  public void visitSequence(@NotNull GitLabYamlSequence o) {
    visitPsiElement(o);
  }

  public void visitSequenceItem(@NotNull GitLabYamlSequenceItem o) {
    visitPsiElement(o);
  }

  public void visitTopLevelMapping(@NotNull GitLabYamlTopLevelMapping o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull GitLabYamlNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
