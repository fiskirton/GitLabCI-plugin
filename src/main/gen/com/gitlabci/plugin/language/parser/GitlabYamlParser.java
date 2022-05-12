// This is a generated file. Not intended for manual editing.
package com.gitlabci.plugin.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes.*;
import static com.gitlabci.plugin.language.parser.GitlabYamlParserUtil.*;
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
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // LBRACKET literal (COMMA (literal | & RBRACKET))* RBRACKET
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY, null);
    r = consumeToken(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, literal(b, l + 1));
    r = p && report_error_(b, array_2(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA (literal | & RBRACKET))*
  private static boolean array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_2", c)) break;
    }
    return true;
  }

  // COMMA (literal | & RBRACKET)
  private static boolean array_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && array_2_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // literal | & RBRACKET
  private static boolean array_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literal(b, l + 1);
    if (!r) r = array_2_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // & RBRACKET
  private static boolean array_2_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DEDENT
  public static boolean block_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_end")) return false;
    if (!nextTokenIs(b, DEDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEDENT);
    exit_section_(b, m, BLOCK_END, r);
    return r;
  }

  /* ********************************************************** */
  // identifier COLON
  static boolean block_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_start")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier COLON identifier
  public static boolean colon_separated(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colon_separated")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, COLON_SEPARATED, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (COMMENT | top_level_mapping)
  static boolean document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "document")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = document_0(b, l + 1);
    r = r && document_1(b, l + 1);
    exit_section_(b, l, m, r, false, GitlabYamlParser::property_recover);
    return r;
  }

  // !<<eof>>
  private static boolean document_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "document_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT | top_level_mapping
  private static boolean document_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "document_1")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = top_level_mapping(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // EOL
  public static boolean end_of_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_of_line")) return false;
    if (!nextTokenIs(b, EOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    exit_section_(b, m, END_OF_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // block_start
  static boolean incomplete_pair(PsiBuilder b, int l) {
    return block_start(b, l + 1);
  }

  /* ********************************************************** */
  // block_start (array | literal | colon_separated | unquoted_string)
  static boolean inline_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_start(b, l + 1);
    r = r && inline_expr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // array | literal | colon_separated | unquoted_string
  private static boolean inline_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_expr_1")) return false;
    boolean r;
    r = array(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = colon_separated(b, l + 1);
    if (!r) r = unquoted_string(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STRING | INT
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    if (!nextTokenIs(b, "<literal>", INT, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, INT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (pair end_of_line*)*
  public static boolean mapping(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping")) return false;
    Marker m = enter_section_(b, l, _NONE_, MAPPING, "<mapping>");
    while (true) {
      int c = current_position_(b);
      if (!mapping_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapping", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // pair end_of_line*
  private static boolean mapping_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pair(b, l + 1);
    r = r && mapping_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // end_of_line*
  private static boolean mapping_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!end_of_line(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapping_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // block_start end_of_line INDENT (sequence | mapping) block_end?
  static boolean nested_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_block")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block_start(b, l + 1);
    r = r && end_of_line(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && nested_block_3(b, l + 1);
    r = r && nested_block_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sequence | mapping
  private static boolean nested_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_block_3")) return false;
    boolean r;
    r = sequence(b, l + 1);
    if (!r) r = mapping(b, l + 1);
    return r;
  }

  // block_end?
  private static boolean nested_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_block_4")) return false;
    block_end(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // UNKNOWN
  static boolean not_used(PsiBuilder b, int l) {
    return consumeToken(b, UNKNOWN);
  }

  /* ********************************************************** */
  // inline_expr
  //        | nested_block
  //        | incomplete_pair
  public static boolean pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inline_expr(b, l + 1);
    if (!r) r = nested_block(b, l + 1);
    if (!r) r = incomplete_pair(b, l + 1);
    exit_section_(b, m, PAIR, r);
    return r;
  }

  /* ********************************************************** */
  // !(INDENT | end_of_line | block_end )
  static boolean property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !property_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INDENT | end_of_line | block_end
  private static boolean property_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0")) return false;
    boolean r;
    r = consumeToken(b, INDENT);
    if (!r) r = end_of_line(b, l + 1);
    if (!r) r = block_end(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // document *
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!document(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (sequence_item end_of_line?)+
  public static boolean sequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence")) return false;
    if (!nextTokenIs(b, DASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sequence_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!sequence_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sequence", c)) break;
    }
    exit_section_(b, m, SEQUENCE, r);
    return r;
  }

  // sequence_item end_of_line?
  private static boolean sequence_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sequence_item(b, l + 1);
    r = r && sequence_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // end_of_line?
  private static boolean sequence_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence_0_1")) return false;
    end_of_line(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DASH (literal | unquoted_string | mapping )
  public static boolean sequence_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence_item")) return false;
    if (!nextTokenIs(b, DASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DASH);
    r = r && sequence_item_1(b, l + 1);
    exit_section_(b, m, SEQUENCE_ITEM, r);
    return r;
  }

  // literal | unquoted_string | mapping
  private static boolean sequence_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence_item_1")) return false;
    boolean r;
    r = literal(b, l + 1);
    if (!r) r = unquoted_string(b, l + 1);
    if (!r) r = mapping(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // mapping
  public static boolean top_level_mapping(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_mapping")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL_MAPPING, "<top level mapping>");
    r = mapping(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (identifier !COLON)+
  public static boolean unquoted_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unquoted_string")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unquoted_string_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!unquoted_string_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unquoted_string", c)) break;
    }
    exit_section_(b, m, UNQUOTED_STRING, r);
    return r;
  }

  // identifier !COLON
  private static boolean unquoted_string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unquoted_string_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && unquoted_string_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !COLON
  private static boolean unquoted_string_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unquoted_string_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
