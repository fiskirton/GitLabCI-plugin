package com.gitlabci.plugin.language.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import java.util.Stack;
import com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes;
import com.intellij.lexer.FlexLexer;

%%

%class GitlabYamlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%eof{  return;
%eof}


%{

    private int currIndent = 0;
    private int sequenceShift = 0;

    private Stack<Integer> indents = new Stack<Integer>();

    private int peek() {
        return indents.empty() ? 0 : indents.peek();
    }

    private int pop() {
        return indents.empty() ? 0 : indents.pop();
    }
%}

// Whitespaces

eol = "\n"
whiteSpace = [ \t]

// Symbols

equal = =
dash = -
plus = \+
asterisk = \*
exlamation = \!
question = \?
underscore = _
colon = :
semicolon = ;
comma = \,
dot = \.
verticalBar = \|
slash = \/
backSlash = \\
at = @
tilda = \~
ampersand = &
dollar = \$
hash = #
percent = %
power = \^

lparen = \(
rparen = \)
lbrace = \{
rbrace = \}
lbracket = \[
rbracket = \]

quote = \'
doubleQuote = \"

// Literals

word = [a-z]+
intLtr = [+-]?\d+
stringLtr = \'[^\'\n]*\'|\"(\\.|[^\"\\\n])*\"
identifier = (_|[a-z]|[A-Z])([_-]|[a-z]|[A-Z]|[0-9])*
non_blank = [^ \t\r\n#]

// Comments
comment = {hash}[^\n\r]*

%state IN_BLOCK STR IN_SEQUENCE IN_VALUE IN_UNQUOTED_STRING

%%

<YYINITIAL> {
      {whiteSpace} {
          currIndent++;
      }
      {eol} {sequenceShift = 0; currIndent = 0;}
      {comment} { return GitlabYamlTokenTypes.COMMENT; }

      {non_blank} {
          yypushback(1);
          if((peek() > currIndent - sequenceShift) && (peek() > currIndent)) {
            pop();
            sequenceShift = 0;
            return GitlabYamlTokenTypes.DEDENT;
          }
          yybegin(IN_BLOCK);
          if((peek() < currIndent - sequenceShift) && (peek() < currIndent)) {
            indents.push(currIndent - sequenceShift);
            return GitlabYamlTokenTypes.INDENT;
          }
      }

}

<IN_BLOCK> {
    {dash} {whiteSpace} {identifier} {colon} {
              sequenceShift = 0;
              yypushback(yylength());
              yybegin(IN_SEQUENCE);
    }

    {dash} {yybegin(IN_VALUE); return GitlabYamlTokenTypes.DASH;}
    {colon} {yybegin(IN_VALUE); return GitlabYamlTokenTypes.COLON;}
    {comma} {return GitlabYamlTokenTypes.COMMA;}
    {lbracket} {return GitlabYamlTokenTypes.LBRACKET;}
    {rbracket} {return GitlabYamlTokenTypes.RBRACKET;}
    {intLtr} {return GitlabYamlTokenTypes.INT;}
    {stringLtr} {return GitlabYamlTokenTypes.STRING;}

    {eol} {
      yybegin(YYINITIAL);
      currIndent = 0;
      return GitlabYamlTokenTypes.EOL;
    }
    {identifier} {return GitlabYamlTokenTypes.ID;}
    {whiteSpace} {return TokenType.WHITE_SPACE;}
    {comment} { return GitlabYamlTokenTypes.COMMENT; }
}

<IN_SEQUENCE> {
    {dash} {sequenceShift++; return GitlabYamlTokenTypes.DASH;}
    {colon} {
          yypushback(yylength());
          yybegin(IN_BLOCK);
      }
    {identifier} {return GitlabYamlTokenTypes.ID;}
    {whiteSpace} {sequenceShift++; return TokenType.WHITE_SPACE;}
}

<IN_VALUE> {
    {whiteSpace} {return TokenType.WHITE_SPACE;}
    ['\"\[] {yypushback(yylength()); yybegin(IN_BLOCK);}
    [^'\"\[] {yypushback(yylength());yybegin(IN_UNQUOTED_STRING);}
}

<IN_UNQUOTED_STRING> {
    {intLtr}+ {return GitlabYamlTokenTypes.INT;}
    [^\r\n#]+ {return GitlabYamlTokenTypes.STRING;}
    {eol} {yypushback(yylength()); yybegin(IN_BLOCK);}
}

[^] {return GitlabYamlTokenTypes.UNKNOWN;}