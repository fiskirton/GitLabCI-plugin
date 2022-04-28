// This is a generated file. Not intended for manual editing.
package com.github.fiskirton.gitlabciplugin.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.fiskirton.gitlabciplugin.language.psi.GitlabYamlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GitlabYamlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    boolean r;
    if (t == BLOCK) {
      r = block(b, l + 1);
    }
    else {
      r = root(b, l + 1);
    }
    return r;
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARRAY_LIST_BLOCK, BLOCK, INLINE_BLOCK, NESTED_BLOCK),
  };

  /* ********************************************************** */
  // inline_expr | colon_separated_expr
  public static boolean array_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_ELEMENT, "<array element>");
    r = inline_expr(b, l + 1);
    if (!r) r = colon_separated_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // block_start array_list_entry+
  public static boolean array_list_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_list_block")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_start(b, l + 1);
    r = r && array_list_block_1(b, l + 1);
    exit_section_(b, m, ARRAY_LIST_BLOCK, r);
    return r;
  }

  // array_list_entry+
  private static boolean array_list_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_list_block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_list_entry(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!array_list_entry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_list_block_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '-' array_element
  static boolean array_list_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_list_entry")) return false;
    if (!nextTokenIs(b, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUS);
    r = r && array_element(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // inline_block
  //  | array_list_block
  //  | nested_block
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BLOCK, null);
    r = inline_block(b, l + 1);
    if (!r) r = array_list_block(b, l + 1);
    if (!r) r = nested_block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key COLON
  static boolean block_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_start")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // key ':' key
  static boolean colon_separated_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colon_separated_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && key(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> block
  static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = element_0(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, GitlabYamlParser::property_recover);
    return r;
  }

  // !<<eof>>
  private static boolean element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' inline_expr (',' (inline_expr | &']'))* ']'
  public static boolean inline_array_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_array_expr")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INLINE_ARRAY_EXPR, null);
    r = consumeToken(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, inline_expr(b, l + 1));
    r = p && report_error_(b, inline_array_expr_2(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' (inline_expr | &']'))*
  private static boolean inline_array_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_array_expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inline_array_expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inline_array_expr_2", c)) break;
    }
    return true;
  }

  // ',' (inline_expr | &']')
  private static boolean inline_array_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_array_expr_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && inline_array_expr_2_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // inline_expr | &']'
  private static boolean inline_array_expr_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_array_expr_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inline_expr(b, l + 1);
    if (!r) r = inline_array_expr_2_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &']'
  private static boolean inline_array_expr_2_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_array_expr_2_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // block_start value
  public static boolean inline_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_block")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_start(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, INLINE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | INT
  public static boolean inline_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_expr")) return false;
    if (!nextTokenIs(b, "<inline expr>", INT, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_EXPR, "<inline expr>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, INT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, KEY, r);
    return r;
  }

  /* ********************************************************** */
  // block_start block
  public static boolean nested_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_block")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_start(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, NESTED_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // !(block_start)
  static boolean property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !property_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (block_start)
  private static boolean property_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_start(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // element *
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // inline_expr | inline_array_expr | colon_separated_expr
  static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    r = inline_expr(b, l + 1);
    if (!r) r = inline_array_expr(b, l + 1);
    if (!r) r = colon_separated_expr(b, l + 1);
    return r;
  }

}
