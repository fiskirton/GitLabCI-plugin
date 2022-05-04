// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class GitlabYamlVisitor extends PsiElementVisitor {

  public void visitArray(@NotNull GitlabYamlArray o) {
    visitPsiElement(o);
  }

  public void visitColonSeparated(@NotNull GitlabYamlColonSeparated o) {
    visitPsiElement(o);
  }

  public void visitLiteral(@NotNull GitlabYamlLiteral o) {
    visitPsiElement(o);
  }

  public void visitMapping(@NotNull GitlabYamlMapping o) {
    visitPsiElement(o);
  }

  public void visitPair(@NotNull GitlabYamlPair o) {
    visitPsiElement(o);
  }

  public void visitSequence(@NotNull GitlabYamlSequence o) {
    visitPsiElement(o);
  }

  public void visitSequenceItem(@NotNull GitlabYamlSequenceItem o) {
    visitPsiElement(o);
  }

  public void visitUnquotedString(@NotNull GitlabYamlUnquotedString o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
