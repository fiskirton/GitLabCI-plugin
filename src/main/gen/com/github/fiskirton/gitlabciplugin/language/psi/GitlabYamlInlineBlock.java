// This is a generated file. Not intended for manual editing.
package com.github.fiskirton.gitlabciplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GitlabYamlInlineBlock extends GitlabYamlBlock {

  @Nullable
  GitlabYamlInlineArrayExpr getInlineArrayExpr();

  @Nullable
  GitlabYamlInlineExpr getInlineExpr();

  @NotNull
  List<GitlabYamlKey> getKeyList();

}
