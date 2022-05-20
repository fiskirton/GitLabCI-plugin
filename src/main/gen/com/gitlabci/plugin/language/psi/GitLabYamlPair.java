// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GitLabYamlPair extends PsiElement {

  @Nullable
  GitLabYamlArray getArray();

  @Nullable
  GitLabYamlBlockEnd getBlockEnd();

  @Nullable
  GitLabYamlEndOfLine getEndOfLine();

  @NotNull
  GitLabYamlIdentifier getIdentifier();

  @Nullable
  GitLabYamlLiteral getLiteral();

  @Nullable
  GitLabYamlMapping getMapping();

  @Nullable
  GitLabYamlSequence getSequence();

}
