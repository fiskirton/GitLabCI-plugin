package com.gitlabci.plugin.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import java.util.Stack;
import com.gitlabci.plugin.language.psi.GitLabYamlTokenTypes;

%%

%class GitLabYamlSyntaxHighlighterLexer
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
comment = {hash} [^\n\r]*

%state IN_UNQUOTED_STRING IN_BLOCK_START PROCESS_UNQUOTED

%%

<YYINITIAL> {
    {whiteSpace} {return TokenType.WHITE_SPACE;}
    {eol} {return GitLabYamlTokenTypes.EOL;}
    {comment} {return GitLabYamlTokenTypes.COMMENT;}

    {identifier} {colon} {whiteSpace}+ [^'\"\[] {
        yypushback(yylength());
        yybegin(IN_UNQUOTED_STRING);
    }

    {dash} {whiteSpace}+ [^'\"] {
        yypushback(yylength());
        yybegin(IN_UNQUOTED_STRING);
    }

    {dash} {return GitLabYamlTokenTypes.DASH;}
    {colon} {return GitLabYamlTokenTypes.COLON;}
    {comma} {return GitLabYamlTokenTypes.COMMA;}
    {lbracket} {return GitLabYamlTokenTypes.LBRACKET;}
    {rbracket} {return GitLabYamlTokenTypes.RBRACKET;}
    {intLtr} {return GitLabYamlTokenTypes.INT;}
    {stringLtr} {return GitLabYamlTokenTypes.STRING;}
    {identifier} {return GitLabYamlTokenTypes.ID;}

}

<IN_UNQUOTED_STRING> {
    {dash} {return GitLabYamlTokenTypes.DASH;}
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
    {identifier} {return GitLabYamlTokenTypes.ID;}
    {colon} {return GitLabYamlTokenTypes.COLON;}
    {whiteSpace} {yybegin(IN_UNQUOTED_STRING); return TokenType.WHITE_SPACE;}
}

<PROCESS_UNQUOTED> {
    {intLtr}+ {return GitLabYamlTokenTypes.INT;}
    [^\r\n#]+ {return GitLabYamlTokenTypes.STRING;}
    {comment} {return GitLabYamlTokenTypes.COMMENT;}
    {eol} {yybegin(YYINITIAL); return GitLabYamlTokenTypes.EOL;}
}

[^] {return GitLabYamlTokenTypes.UNKNOWN;}

//<IN_STR>{
//    {stringLtr} {currString += yytext();}
//    \\$ { /* */ }
//    "\"" {yybegin(IN_BLOCK); return GitLabYamlTokenTypes.STRING;}
//}

    // Gloabl keywords
//    "default" {return GitLabYamlTokenTypes.DEFAULT;}
//    "include" {return GitLabYamlTokenTypes.INCLUDE;}
//    "stages" {return GitLabYamlTokenTypes.STAGES;}
//    "variables" {return GitLabYamlTokenTypes.VARIABLES;}
//    "workflow" {return GitLabYamlTokenTypes.WORKFLOW;}

    // Job keywords

//    "after_script" {return GitLabYamlTokenTypes.IN_BLOCK_SCRIPT;}
//    "allow_failure" {return GitLabYamlTokenTypes.ALLOW_FAILURE;}
//    "artifacts" {return GitLabYamlTokenTypes.ARTIFACTS;}
//    "before_script" {return GitLabYamlTokenTypes.BEFORE_SCRIPT;}
//    "cache" {return GitLabYamlTokenTypes.CACHE;}
//    "coverage" {return GitLabYamlTokenTypes.COVERAGE;}
//    "dast_configuration" {return GitLabYamlTokenTypes.DAST_CONFIGURATION;}
//    "dependencies" {return GitLabYamlTokenTypes.DEPENDENCIES;}
//    "environment" {return GitLabYamlTokenTypes.ENVIRONMENT;}
//    "except" {return GitLabYamlTokenTypes.EXCEPT;}
//    "extends" {return GitLabYamlTokenTypes.EXTENDS;}
//    "image" {return GitLabYamlTokenTypes.IMAGE;}
//    "inherit" {return GitLabYamlTokenTypes.INHERIT;}
//    "interruptible" {return GitLabYamlTokenTypes.INTERRUPTIBLE;}
//    "needs" {return GitLabYamlTokenTypes.NEEDS;}
//    "only" {return GitLabYamlTokenTypes.ONLY;}
//    "pages" {return GitLabYamlTokenTypes.PAGES;}
//    "parallel" {return GitLabYamlTokenTypes.PARALLEL;}
//    "release" {return GitLabYamlTokenTypes.RELEASE;}
//    "resource_group" {return GitLabYamlTokenTypes.RESOURCE_GROUP;}
//    "retry" {return GitLabYamlTokenTypes.RETRY;}
//    "rules" {return GitLabYamlTokenTypes.RULES;}
//    "script" {return GitLabYamlTokenTypes.SCRIPT;}
//    "secrets" {return GitLabYamlTokenTypes.SECRETS;}
//    "services" {return GitLabYamlTokenTypes.SERVICES;}
//    "stage" {return GitLabYamlTokenTypes.STAGE;}
//    "tags" {return GitLabYamlTokenTypes.TAGS;}
//    "timeout" {return GitLabYamlTokenTypes.TIMEOUT;}
//    "trigger" {return GitLabYamlTokenTypes.TRIGGER;}
//    "variables" {return GitLabYamlTokenTypes.VARIABLES;}
//    "when" {return GitLabYamlTokenTypes.WHEN;}

    // Special chars

//    {equal} {return GitLabYamlTokenTypes.EQUAL;}
//    {plus} {return GitLabYamlTokenTypes.PLUS;}
//    {asterisk} {return GitLabYamlTokenTypes.ASTERISK;}
//    {exlamation} {return GitLabYamlTokenTypes.EXCLAMATION;}
//    {question} {return GitLabYamlTokenTypes.QUESTION;}
//    {underscore} {return GitLabYamlTokenTypes.UNDERSCORE;}

//    {semicolon} {return GitLabYamlTokenTypes.SEMICOLON;}

//    {dot} {return GitLabYamlTokenTypes.DOT;}
//    {verticalBar} {return GitLabYamlTokenTypes.VERTICAL_BAR;}
//    {slash} {return GitLabYamlTokenTypes.SLASH;}
//    {backSlash} {return GitLabYamlTokenTypes.BACK_SLASH;}
//    {at} {return GitLabYamlTokenTypes.AT;}
//    {tilda} {return GitLabYamlTokenTypes.TILDA;}
//    {ampersand} {return GitLabYamlTokenTypes.AMPERSAND;}
//    {dollar} {return GitLabYamlTokenTypes.DOLLAR;}
//    {hash} {return GitLabYamlTokenTypes.HASH;}
//    {percent} {return GitLabYamlTokenTypes.PERCENT;}
//    {power} {return GitLabYamlTokenTypes.POWER;}
//    {lparen} {return GitLabYamlTokenTypes.LPAREN;}
//    {rparen} {return GitLabYamlTokenTypes.RPAREN;}
//    {lbrace} {return GitLabYamlTokenTypes.LBRACE;}
//    {rbrace} {return GitLabYamlTokenTypes.RBRACE;}
//    {quote} {return GitLabYamlTokenTypes.QUOTE;}
//    {doubleQuote} {return GitLabYamlTokenTypes.DOUBLE_QUOTE;}

//}