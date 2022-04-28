// This is a generated file. Not intended for manual editing.
package com.github.fiskirton.gitlabciplugin.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class GitlabYamlVisitor extends PsiElementVisitor {

  public void visitArrayElement(@NotNull GitlabYamlArrayElement o) {
    visitPsiElement(o);
  }

  public void visitArrayListBlock(@NotNull GitlabYamlArrayListBlock o) {
    visitBlock(o);
  }

  public void visitBlock(@NotNull GitlabYamlBlock o) {
    visitPsiElement(o);
  }

  public void visitInlineArrayExpr(@NotNull GitlabYamlInlineArrayExpr o) {
    visitPsiElement(o);
  }

  public void visitInlineBlock(@NotNull GitlabYamlInlineBlock o) {
    visitBlock(o);
  }

  public void visitInlineExpr(@NotNull GitlabYamlInlineExpr o) {
    visitPsiElement(o);
  }

  public void visitKey(@NotNull GitlabYamlKey o) {
    visitPsiElement(o);
  }

  public void visitNestedBlock(@NotNull GitlabYamlNestedBlock o) {
    visitBlock(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
