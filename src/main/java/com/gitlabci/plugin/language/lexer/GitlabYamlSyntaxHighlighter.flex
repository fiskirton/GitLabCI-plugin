package com.gitlabci.plugin.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import java.util.Stack;
import com.gitlabci.plugin.language.psi.GitlabYamlTokenTypes;

%%

%class GitlabYamlSyntaxHighlighterLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%eof{  return;
%eof}


%{

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

intLtr = [+-]?\d+
stringLtr = \'[^\'\n]*\'|\"(\\.|[^\"\\\n])*\"
identifier = (_|[a-z]|[A-Z])([_-]|[a-z]|[A-Z]|[0-9])*
non_blank = [^ \t\r\n#]

// Comments
comment = {hash}[^\n\r]*

%state IN_UNQUOTED_STRING IN_BLOCK_START PROCESS_UNQUOTED

%%

<YYINITIAL> {
    {whiteSpace} {return TokenType.WHITE_SPACE;}
    {eol} {return GitlabYamlTokenTypes.EOL;}
    {comment} {return GitlabYamlTokenTypes.COMMENT;}

    {identifier} {colon} {whiteSpace}+ [^'\"\[] {
        yypushback(yylength());
        yybegin(IN_UNQUOTED_STRING);
    }

    {dash} {whiteSpace}+ [^'\"] {
        yypushback(yylength());
        yybegin(IN_UNQUOTED_STRING);
    }

    {dash} {return GitlabYamlTokenTypes.DASH;}
    {colon} {return GitlabYamlTokenTypes.COLON;}
    {comma} {return GitlabYamlTokenTypes.COMMA;}
    {lbracket} {return GitlabYamlTokenTypes.LBRACKET;}
    {rbracket} {return GitlabYamlTokenTypes.RBRACKET;}
    {intLtr} {return GitlabYamlTokenTypes.INT;}
    {stringLtr} {return GitlabYamlTokenTypes.STRING;}
    {identifier} {return GitlabYamlTokenTypes.ID;}

}

<IN_UNQUOTED_STRING> {
    {dash} {return GitlabYamlTokenTypes.DASH;}
    {identifier} {colon} {whiteSpace} {
      yypushback(yylength());
      yybegin(IN_BLOCK_START);
    }
    {whiteSpace} {return TokenType.WHITE_SPACE;}

    {non_blank} {
        yypushback(1);
        yybegin(PROCESS_UNQUOTED);
    }
}

<IN_BLOCK_START> {
    {identifier} {return GitlabYamlTokenTypes.ID;}
    {colon} {return GitlabYamlTokenTypes.COLON;}
    {whiteSpace} {yybegin(IN_UNQUOTED_STRING); return TokenType.WHITE_SPACE;}
}

<PROCESS_UNQUOTED> {
    {intLtr}+ {return GitlabYamlTokenTypes.INT;}
    [^\r\n#]+ {return GitlabYamlTokenTypes.STRING;}
    {eol} {yybegin(YYINITIAL); return GitlabYamlTokenTypes.EOL;}
}

[^] {return GitlabYamlTokenTypes.UNKNOWN;}

//<IN_STR>{
//    {stringLtr} {currString += yytext();}
//    \\$ { /* */ }
//    "\"" {yybegin(IN_BLOCK); return GitlabYamlTokenTypes.STRING;}
//}

    // Gloabl keywords
//    "default" {return GitlabYamlTokenTypes.DEFAULT;}
//    "include" {return GitlabYamlTokenTypes.INCLUDE;}
//    "stages" {return GitlabYamlTokenTypes.STAGES;}
//    "variables" {return GitlabYamlTokenTypes.VARIABLES;}
//    "workflow" {return GitlabYamlTokenTypes.WORKFLOW;}

    // Job keywords

//    "after_script" {return GitlabYamlTokenTypes.IN_BLOCK_SCRIPT;}
//    "allow_failure" {return GitlabYamlTokenTypes.ALLOW_FAILURE;}
//    "artifacts" {return GitlabYamlTokenTypes.ARTIFACTS;}
//    "before_script" {return GitlabYamlTokenTypes.BEFORE_SCRIPT;}
//    "cache" {return GitlabYamlTokenTypes.CACHE;}
//    "coverage" {return GitlabYamlTokenTypes.COVERAGE;}
//    "dast_configuration" {return GitlabYamlTokenTypes.DAST_CONFIGURATION;}
//    "dependencies" {return GitlabYamlTokenTypes.DEPENDENCIES;}
//    "environment" {return GitlabYamlTokenTypes.ENVIRONMENT;}
//    "except" {return GitlabYamlTokenTypes.EXCEPT;}
//    "extends" {return GitlabYamlTokenTypes.EXTENDS;}
//    "image" {return GitlabYamlTokenTypes.IMAGE;}
//    "inherit" {return GitlabYamlTokenTypes.INHERIT;}
//    "interruptible" {return GitlabYamlTokenTypes.INTERRUPTIBLE;}
//    "needs" {return GitlabYamlTokenTypes.NEEDS;}
//    "only" {return GitlabYamlTokenTypes.ONLY;}
//    "pages" {return GitlabYamlTokenTypes.PAGES;}
//    "parallel" {return GitlabYamlTokenTypes.PARALLEL;}
//    "release" {return GitlabYamlTokenTypes.RELEASE;}
//    "resource_group" {return GitlabYamlTokenTypes.RESOURCE_GROUP;}
//    "retry" {return GitlabYamlTokenTypes.RETRY;}
//    "rules" {return GitlabYamlTokenTypes.RULES;}
//    "script" {return GitlabYamlTokenTypes.SCRIPT;}
//    "secrets" {return GitlabYamlTokenTypes.SECRETS;}
//    "services" {return GitlabYamlTokenTypes.SERVICES;}
//    "stage" {return GitlabYamlTokenTypes.STAGE;}
//    "tags" {return GitlabYamlTokenTypes.TAGS;}
//    "timeout" {return GitlabYamlTokenTypes.TIMEOUT;}
//    "trigger" {return GitlabYamlTokenTypes.TRIGGER;}
//    "variables" {return GitlabYamlTokenTypes.VARIABLES;}
//    "when" {return GitlabYamlTokenTypes.WHEN;}

    // Special chars

//    {equal} {return GitlabYamlTokenTypes.EQUAL;}
//    {plus} {return GitlabYamlTokenTypes.PLUS;}
//    {asterisk} {return GitlabYamlTokenTypes.ASTERISK;}
//    {exlamation} {return GitlabYamlTokenTypes.EXCLAMATION;}
//    {question} {return GitlabYamlTokenTypes.QUESTION;}
//    {underscore} {return GitlabYamlTokenTypes.UNDERSCORE;}

//    {semicolon} {return GitlabYamlTokenTypes.SEMICOLON;}

//    {dot} {return GitlabYamlTokenTypes.DOT;}
//    {verticalBar} {return GitlabYamlTokenTypes.VERTICAL_BAR;}
//    {slash} {return GitlabYamlTokenTypes.SLASH;}
//    {backSlash} {return GitlabYamlTokenTypes.BACK_SLASH;}
//    {at} {return GitlabYamlTokenTypes.AT;}
//    {tilda} {return GitlabYamlTokenTypes.TILDA;}
//    {ampersand} {return GitlabYamlTokenTypes.AMPERSAND;}
//    {dollar} {return GitlabYamlTokenTypes.DOLLAR;}
//    {hash} {return GitlabYamlTokenTypes.HASH;}
//    {percent} {return GitlabYamlTokenTypes.PERCENT;}
//    {power} {return GitlabYamlTokenTypes.POWER;}
//    {lparen} {return GitlabYamlTokenTypes.LPAREN;}
//    {rparen} {return GitlabYamlTokenTypes.RPAREN;}
//    {lbrace} {return GitlabYamlTokenTypes.LBRACE;}
//    {rbrace} {return GitlabYamlTokenTypes.RBRACE;}
//    {quote} {return GitlabYamlTokenTypes.QUOTE;}
//    {doubleQuote} {return GitlabYamlTokenTypes.DOUBLE_QUOTE;}

//}