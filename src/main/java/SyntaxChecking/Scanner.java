// the scanner scans in characters from a 'SourceFile'
// It reads in chars by calling on the getSource() method
// on the 'SourceFile'.
// It creates Tokens out of what it reads in.
// An instance of the scanner will be handed off to the parser;
// the parser will get the next token by calling the scan() method.

package SyntaxChecking;

import SyntaxChecking.SourceFile;
import SyntaxChecking.JSToken;
import SyntaxChecking.SourcePosition;

public class Scanner
{
    private SourceFile      sf;
    private char            currentChar;
    private StringBuffer    currentSpelling;
    private boolean         currentlyScanningToken;

    public Scanner(SourceFile file)
    {
        sf = file;
        currentChar = sf.getSource();
    }

    private boolean isLetter(char c)
    {
        return ('a' <= c && c <= 'z') ||
               ('A' <= c && c <= 'Z');
    }

    private boolean isDigit(char c)
    {
        return ('0' <= c && c <= '9');
    }

    private boolean isOperator(char c)
    {
        return (c == '+' || c == '-' || c == '/' || c == '*' ||
                c == '=' || c == '>' || c == '<' || c == '?');
    }

    private void takeIt()
    {
        if (currentlyScanningToken)
        {
            currentSpelling.append(currentChar);
        }
        currentChar = sf.getSource();
    }

    private JSToken scanToken()
    {
        switch (currentChar)
        {
            case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
            case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
            case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
            case 'p':  case 'q':  case 'r':  case 's':  case 't':
            case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
            case 'z':
            case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
            case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
            case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
            case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
            case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
            case 'Z':
                takeIt();
                while (isLetter(currentChar) || isDigit(currentChar))
                {
                    takeIt();
                }
                return JSToken.IDENTIFIER;

            case '0': case '1': case '2': case '3': case '4':
            case '5': case '6': case '7': case '8': case '9':
                takeIt();
                while (isDigit(currentChar))
                {
                    takeIt();
                }
                return JSToken.INTLITERAL;

            case '+': case '-': case '*': case '/':
            case '=': case '>': case '<':
                takeIt();
                return JSToken.OPERATOR;

            case ';':
                takeIt();
                return JSToken.SEMICOLON;

            case ':':
                takeIt();
                if (currentChar == '=')
                {
                    takeIt();
                    return JSToken.BECOMES;
                }
                return JSToken.COLON;

            case '(':
                takeIt();
                return JSToken.LPAREN;

            case ')':
                takeIt();
                return JSToken.RPAREN;

            case '{':
                takeIt();
                return JSToken.LCURLY;

            case '}':
                takeIt();
                return JSToken.RCURLY;

            case SourceFile.EOT:
                return JSToken.EOT;

            default:
                takeIt();
                return JSToken.ERROR;
        }
    }

    public Token scan()
    {
        currentlyScanningToken = false;

        // eat away any whitespace first
        while (currentChar == ' '  ||
               currentChar == '\n' ||
               currentChar == '\r' ||
               currentChar == '\t')
        {
            takeIt();
        }

        // now scan the token
        currentlyScanningToken = true;
        currentSpelling = null;
        currentSpelling = new StringBuffer("");

        SourcePosition pos = new SourcePosition();
        pos.start  = sf.getCurrentLine();
        pos.finish = sf.getCurrentCol();

        JSToken tk = scanToken();
        Token  tok = new Token(tk, currentSpelling.toString(), pos);
        return tok;
    }
}