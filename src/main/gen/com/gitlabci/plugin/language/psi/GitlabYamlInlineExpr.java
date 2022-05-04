// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GitlabYamlInlineExpr extends PsiElement {

  @Nullable
  GitlabYamlArray getArray();

  @Nullable
  GitlabYamlColonSeparated getColonSeparated();

  @Nullable
  GitlabYamlLiteral getLiteral();

  @Nullable
  GitlabYamlUnquotedString getUnquotedString();

}
