// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GitlabYamlSequenceItem extends PsiElement {

  @Nullable
  GitlabYamlLiteral getLiteral();

  @Nullable
  GitlabYamlMapping getMapping();

  @Nullable
  GitlabYamlUnquotedString getUnquotedString();

}
