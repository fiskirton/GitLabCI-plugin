// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.gitlabci.plugin.language.psi.impl.*;

public interface GitlabYamlTokenTypes {

  IElementType ARRAY = new GitlabYamlElementType("ARRAY");
  IElementType BLOCK_END = new GitlabYamlElementType("BLOCK_END");
  IElementType COLON_SEPARATED = new GitlabYamlElementType("COLON_SEPARATED");
  IElementType END_OF_LINE = new GitlabYamlElementType("END_OF_LINE");
  IElementType IDENTIFIER = new GitlabYamlElementType("IDENTIFIER");
  IElementType LITERAL = new GitlabYamlElementType("LITERAL");
  IElementType MAPPING = new GitlabYamlElementType("MAPPING");
  IElementType PAIR = new GitlabYamlElementType("PAIR");
  IElementType SEQUENCE = new GitlabYamlElementType("SEQUENCE");
  IElementType SEQUENCE_ITEM = new GitlabYamlElementType("SEQUENCE_ITEM");
  IElementType TOP_LEVEL_MAPPING = new GitlabYamlElementType("TOP_LEVEL_MAPPING");
  IElementType UNQUOTED_STRING = new GitlabYamlElementType("UNQUOTED_STRING");

  IElementType COLON = new GitlabYamlTokenType("COLON");
  IElementType COMMA = new GitlabYamlTokenType("COMMA");
  IElementType COMMENT = new GitlabYamlTokenType("COMMENT");
  IElementType DASH = new GitlabYamlTokenType("DASH");
  IElementType DEDENT = new GitlabYamlTokenType("DEDENT");
  IElementType EOL = new GitlabYamlTokenType("EOL");
  IElementType ID = new GitlabYamlTokenType("ID");
  IElementType INDENT = new GitlabYamlTokenType("INDENT");
  IElementType INT = new GitlabYamlTokenType("INT");
  IElementType LBRACKET = new GitlabYamlTokenType("LBRACKET");
  IElementType RBRACKET = new GitlabYamlTokenType("RBRACKET");
  IElementType STRING = new GitlabYamlTokenType("STRING");
  IElementType UNKNOWN = new GitlabYamlTokenType("UNKNOWN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY) {
        return new GitlabYamlArrayImpl(node);
      }
      else if (type == BLOCK_END) {
        return new GitlabYamlBlockEndImpl(node);
      }
      else if (type == COLON_SEPARATED) {
        return new GitlabYamlColonSeparatedImpl(node);
      }
      else if (type == END_OF_LINE) {
        return new GitlabYamlEndOfLineImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new GitlabYamlIdentifierImpl(node);
      }
      else if (type == LITERAL) {
        return new GitlabYamlLiteralImpl(node);
      }
      else if (type == MAPPING) {
        return new GitlabYamlMappingImpl(node);
      }
      else if (type == PAIR) {
        return new GitlabYamlPairImpl(node);
      }
      else if (type == SEQUENCE) {
        return new GitlabYamlSequenceImpl(node);
      }
      else if (type == SEQUENCE_ITEM) {
        return new GitlabYamlSequenceItemImpl(node);
      }
      else if (type == TOP_LEVEL_MAPPING) {
        return new GitlabYamlTopLevelMappingImpl(node);
      }
      else if (type == UNQUOTED_STRING) {
        return new GitlabYamlUnquotedStringImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
