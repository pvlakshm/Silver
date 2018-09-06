package SyntaxChecking;

enum JSToken {
    INTLITERAL,
    IDENTIFIER,
    OPERATOR,

    // punctuation
    SEMICOLON,
    COLON,
    BECOMES,

    // brackets
    LPAREN,
    RPAREN,
    LCURLY,
    RCURLY,

    // special tokens
    EOT,
    ERROR,

    // keywords
    VAR,
    LET,
    IF,
    ELSE,
    WHILE,
    CONST
}

public class Token {
    private static String[] keywordTable = {
        // in the same order as the keywords kinds above
        "var",
        "let",
        "if",
        "else",
        "while",
        "const",
    };

    private static int firstReservedWordIndex = JSToken.VAR.ordinal();

    // these are package scoped. I want to be able to access a
    // token's kind and spelling while parsing.
    JSToken         kind;
    String          spelling;
    SourcePosition  position;

    public Token(JSToken theKind, String theSpelling, SourcePosition pos)
    {
        if (theKind == JSToken.IDENTIFIER)
        {
            // if kind is IDENTIFIER, and the spelling matches
            // one of the keywords, update kind aa.
            for (int i = 0; i <= keywordTable.length - 1; i++)
            {
                if (theSpelling.equals(keywordTable[i]))
                {
                    theKind = JSToken.values()[i + firstReservedWordIndex];
                    break;
                }
            }
        }

        kind     = theKind;
        spelling = theSpelling;
        position = pos;
    }
}