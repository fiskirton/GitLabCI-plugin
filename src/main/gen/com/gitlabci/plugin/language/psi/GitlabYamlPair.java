// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GitlabYamlPair extends PsiElement {

  @Nullable
  GitlabYamlArray getArray();

  @Nullable
  GitlabYamlBlockEnd getBlockEnd();

  @Nullable
  GitlabYamlColonSeparated getColonSeparated();

  @Nullable
  GitlabYamlEndOfLine getEndOfLine();

  @NotNull
  GitlabYamlIdentifier getIdentifier();

  @Nullable
  GitlabYamlLiteral getLiteral();

  @Nullable
  GitlabYamlMapping getMapping();

  @Nullable
  GitlabYamlSequence getSequence();

  @Nullable
  GitlabYamlUnquotedString getUnquotedString();

}
