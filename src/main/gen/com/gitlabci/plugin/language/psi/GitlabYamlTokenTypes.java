// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.gitlabci.plugin.language.psi.impl.*;

public interface GitLabYamlTokenTypes {

  IElementType ARRAY = new GitLabYamlElementType("ARRAY");
  IElementType BLOCK_END = new GitLabYamlElementType("BLOCK_END");
  IElementType END_OF_LINE = new GitLabYamlElementType("END_OF_LINE");
  IElementType IDENTIFIER = new GitLabYamlElementType("IDENTIFIER");
  IElementType LITERAL = new GitLabYamlElementType("LITERAL");
  IElementType MAPPING = new GitLabYamlElementType("MAPPING");
  IElementType PAIR = new GitLabYamlElementType("PAIR");
  IElementType SEQUENCE = new GitLabYamlElementType("SEQUENCE");
  IElementType SEQUENCE_ITEM = new GitLabYamlElementType("SEQUENCE_ITEM");
  IElementType TOP_LEVEL_MAPPING = new GitLabYamlElementType("TOP_LEVEL_MAPPING");

  IElementType COLON = new GitLabYamlTokenType("COLON");
  IElementType COMMA = new GitLabYamlTokenType("COMMA");
  IElementType COMMENT = new GitLabYamlTokenType("COMMENT");
  IElementType DASH = new GitLabYamlTokenType("DASH");
  IElementType DEDENT = new GitLabYamlTokenType("DEDENT");
  IElementType EOL = new GitLabYamlTokenType("EOL");
  IElementType ID = new GitLabYamlTokenType("ID");
  IElementType INDENT = new GitLabYamlTokenType("INDENT");
  IElementType INT = new GitLabYamlTokenType("INT");
  IElementType LBRACKET = new GitLabYamlTokenType("LBRACKET");
  IElementType RBRACKET = new GitLabYamlTokenType("RBRACKET");
  IElementType STRING = new GitLabYamlTokenType("STRING");
  IElementType UNKNOWN = new GitLabYamlTokenType("UNKNOWN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY) {
        return new GitLabYamlArrayImpl(node);
      }
      else if (type == BLOCK_END) {
        return new GitLabYamlBlockEndImpl(node);
      }
      else if (type == END_OF_LINE) {
        return new GitLabYamlEndOfLineImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new GitLabYamlIdentifierImpl(node);
      }
      else if (type == LITERAL) {
        return new GitLabYamlLiteralImpl(node);
      }
      else if (type == MAPPING) {
        return new GitLabYamlMappingImpl(node);
      }
      else if (type == PAIR) {
        return new GitLabYamlPairImpl(node);
      }
      else if (type == SEQUENCE) {
        return new GitLabYamlSequenceImpl(node);
      }
      else if (type == SEQUENCE_ITEM) {
        return new GitLabYamlSequenceItemImpl(node);
      }
      else if (type == TOP_LEVEL_MAPPING) {
        return new GitLabYamlTopLevelMappingImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
