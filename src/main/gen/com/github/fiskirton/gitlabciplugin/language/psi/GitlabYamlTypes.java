// This is a generated file. Not intended for manual editing.
package com.github.fiskirton.gitlabciplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.fiskirton.gitlabciplugin.language.impl.*;

public interface GitlabYamlTypes {

  IElementType ARRAY_ELEMENT = new GitlabYamlElementType("ARRAY_ELEMENT");
  IElementType ARRAY_LIST_BLOCK = new GitlabYamlElementType("ARRAY_LIST_BLOCK");
  IElementType BLOCK = new GitlabYamlElementType("BLOCK");
  IElementType INLINE_ARRAY_EXPR = new GitlabYamlElementType("INLINE_ARRAY_EXPR");
  IElementType INLINE_BLOCK = new GitlabYamlElementType("INLINE_BLOCK");
  IElementType INLINE_EXPR = new GitlabYamlElementType("INLINE_EXPR");
  IElementType KEY = new GitlabYamlElementType("KEY");
  IElementType NESTED_BLOCK = new GitlabYamlElementType("NESTED_BLOCK");

  IElementType ASSIGN = new GitlabYamlTokenType("=");
  IElementType ASTERISK = new GitlabYamlTokenType("*");
  IElementType BACK_SLASH = new GitlabYamlTokenType("\\");
  IElementType BANG = new GitlabYamlTokenType("!");
  IElementType COLON = new GitlabYamlTokenType(":");
  IElementType COMMA = new GitlabYamlTokenType(",");
  IElementType DOT = new GitlabYamlTokenType(".");
  IElementType EQ = new GitlabYamlTokenType("==");
  IElementType GT = new GitlabYamlTokenType(">");
  IElementType ID = new GitlabYamlTokenType("ID");
  IElementType INT = new GitlabYamlTokenType("INT");
  IElementType LBRACE = new GitlabYamlTokenType("{");
  IElementType LBRACKET = new GitlabYamlTokenType("[");
  IElementType LPAREN = new GitlabYamlTokenType("(");
  IElementType LT = new GitlabYamlTokenType("<");
  IElementType MINUS = new GitlabYamlTokenType("-");
  IElementType NOT_EQ = new GitlabYamlTokenType("!=");
  IElementType PLUS = new GitlabYamlTokenType("+");
  IElementType POWER = new GitlabYamlTokenType("^");
  IElementType QUEST = new GitlabYamlTokenType("?");
  IElementType RBRACE = new GitlabYamlTokenType("}");
  IElementType RBRACKET = new GitlabYamlTokenType("]");
  IElementType RPAREN = new GitlabYamlTokenType(")");
  IElementType SEMICOLON = new GitlabYamlTokenType(";");
  IElementType SLASH = new GitlabYamlTokenType("/");
  IElementType STRING = new GitlabYamlTokenType("STRING");
  IElementType SUB = new GitlabYamlTokenType("$");
  IElementType UNQUOTED = new GitlabYamlTokenType("UNQUOTED");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_ELEMENT) {
        return new GitlabYamlArrayElementImpl(node);
      }
      else if (type == ARRAY_LIST_BLOCK) {
        return new GitlabYamlArrayListBlockImpl(node);
      }
      else if (type == INLINE_ARRAY_EXPR) {
        return new GitlabYamlInlineArrayExprImpl(node);
      }
      else if (type == INLINE_BLOCK) {
        return new GitlabYamlInlineBlockImpl(node);
      }
      else if (type == INLINE_EXPR) {
        return new GitlabYamlInlineExprImpl(node);
      }
      else if (type == KEY) {
        return new GitlabYamlKeyImpl(node);
      }
      else if (type == NESTED_BLOCK) {
        return new GitlabYamlNestedBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
