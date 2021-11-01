/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;
      while (searching) {
          
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;
    //System.out.println("El current Token es: "+tokenTable[this.kind]);
    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    CONST		= 5,
    DO			= 6,
    ELSE		= 7,
    END			= 8,
    FOR                 = 9,        //Nueva linea
    FUNC                = 10,
    FROM                = 11,       //Nueva linea
    IF			= 12,
    IN			= 13,
    LET			= 14,
    LOCAL               = 15,        //Nueva linea
    OF			= 16,
    PROC		= 17,
    RANGE               = 18,        //Nueva linea
    RECORD		= 19,
    RECURSIVE           = 20,        //Nueva linea
    REPEAT              = 21,        //Nueva linea
    SELECT              = 22,        //Nueva linea
    SKIP                = 23,        //Nueva linea
    THEN		= 24,
    TO                  = 25,        //Nueva linea
    TYPE		= 26,
    UNTIL               = 27,        //Nueva linea
    VAR			= 28,
    WHEN                = 29,        //Nueva linea
    WHILE		= 30,

    // punctuation...
    DOT			= 31,
    DOUBLEDOT           = 32,      //Nueva linea
    COLON		= 33,
    SEMICOLON           = 34,
    COMMA		= 35,
    BECOMES		= 36,
    IS			= 37,

    // brackets...
    LPAREN		= 38,
    RPAREN		= 39,
    LBRACKET            = 40,
    RBRACKET            = 41,
    LCURLY		= 42,
    STICK               = 43,      //Nueva linea
    RCURLY		= 44,

    // special tokens...
    COMMENT             = 45,     //Nueva linea
    EOT			= 46,
    ERROR		= 47,
    NEXTLINE            = 48,     //Nueva linea
    SPACE               = 49,     //Nueva linea
    TAB                 = 50;     //Nueva linea

  public static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",        //Se elimino begin
    "const",
    "do",
    "else",
    "end",
    "for",          //Nueva linea
    "func",
    "from",         //Nueva linea
    "if",
    "in",
    "let",
    "local",        //Nueva linea
    "of",
    "proc",
    "range",        //Nueva linea
    "record",
    "recursive",    //Nueva linea  
    "repeat",       //Nueva linea 
    "select",       //Nueva linea
    "skip",         //Nueva linea
    "then",   
    "to",           //Nueva linea
    "type",
    "until",        //Nueva linea
    "var",
    "when",          //Nueva linea
    "while",
    ".",
    "..",           //Nueva linea
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "|",      //Nueva linea
    "}",
    "",
    "\n",
    " ",
    "\t",
    "!",
    "<error>"
  };

  

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
