// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GitlabYamlSequence extends PsiElement {

  @NotNull
  List<GitlabYamlEndOfLine> getEndOfLineList();

  @NotNull
  List<GitlabYamlSequenceItem> getSequenceItemList();

}
