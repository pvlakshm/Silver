/*
Program             ::= singleCommand

Command             ::= singleCommand (; singleCommand)*
 
singleCommand       ::= Identifier := Expression
                    |   if Expression singleCommand else singleCommand
                    |   while Expression singleCommand
                    |   let ( Declaration ) singleCommand
                    |   { Command }

Expression          ::= primaryExpression (operator primaryExpression)*

primaryExpression   ::=  IntegerLiteral
                    |    Vname
                    |    ( Expression )

Declaration         ::= singleDeclaration (; singleDeclartion)*

singleDeclaration   ::= const Identifier := Expression
                    |   var Identifier : Typedenoter
                    |   ( Declaration )
            
Typedenoter         ::= Identifier

Vname               ::= Identifier
*/

import SyntaxChecking.*;

import AST.*;
import AST.Command.*;
import AST.Declaration.*;
import AST.Expression.*;
import AST.Terminal.*;
import AST.TypeDenoter.*;
import AST.Vname.*;

public class Parser
{
    private Scanner sc;
    private Token   currentToken;

    public Parser(Scanner s)
    {
        sc = s;
        currentToken = null;
    }

    private void accept(JSToken expectedToken)
    {
        if (currentToken.kind == expectedToken)
        {
            advance();
            return;
        }
        reportError(currentToken.position + " Error: expected " + "'" + expectedToken +"'");
    }

    private void errorSkipUpto(JSToken expectedToken)
    {
        do
        {
            advance();
        } while (currentToken.kind != expectedToken);
    }

    private void advance()
    {
        currentToken = sc.scan();
    }

    private void reportError(String s)
    {
        System.out.println(s);
    }

    private Identifier parseIdentifier()
    {
        Identifier iAST = new Identifier(currentToken.spelling, currentToken.position);
        advance();
        return iAST;
    }

    private Operator parseOperator()
    {
        Operator oAST = new Operator(currentToken.spelling, currentToken.position);
        advance();
        return oAST;
    }

    private IntegerLiteral parseIntegerLiteral()
    {
        IntegerLiteral iAST = new IntegerLiteral(currentToken.spelling, currentToken.position);
        advance();
        return iAST;
    }

    private Expression parsePrimaryExpression()
    {
        Expression eAST = null;
        
        switch (currentToken.kind)
        {
            case INTLITERAL:
                IntegerLiteral iAST = parseIntegerLiteral();
                eAST = new IntegerExpression(iAST, iAST.getPosition());
                break;
            case IDENTIFIER:
                Identifier i2AST = parseIdentifier();
                SimpleVname vAST = new SimpleVname(i2AST, i2AST.getPosition());
                eAST = new VnameExpression(vAST, vAST.getPosition());
                break;
            case LPAREN:
                advance();
                eAST = parseExpression();
                accept(JSToken.RPAREN);
                break;
            default:
                eAST = new ErrorExpression(currentToken.position);
                break;
        }
        
        return eAST;
    }

    private Expression parseExpression()
    {
        Expression eAST = parsePrimaryExpression();

        while (currentToken.kind == JSToken.OPERATOR)
        {
            Operator oAST = parseOperator();
            Expression e2AST = parsePrimaryExpression();
            eAST = new BinaryExpression(eAST, oAST, e2AST, eAST.getPosition());
        }
 
        return eAST;
    }

    private TypeDenoter parseTypeDenoter()
    {
        Identifier  iAST = parseIdentifier();
        TypeDenoter tAST = new SimpleTypeDenoter(iAST, iAST.getPosition());
        return tAST;
    }
 
    private Declaration parseSingleDeclaration()
    {
        Declaration dAST = null;
        
        switch (currentToken.kind)
        {
            case CONST:
                advance();
                Identifier iAST = parseIdentifier();
                accept(JSToken.BECOMES);
                Expression eAST = parseExpression();
                dAST = new ConstDeclaration(iAST, eAST, iAST.getPosition());
                break;
            case VAR:
                advance();
                Identifier i2AST = parseIdentifier();
                accept(JSToken.COLON);
                TypeDenoter tAST = parseTypeDenoter();
                dAST = new VarDeclaration(i2AST, tAST, i2AST.getPosition());
                break;
            default:
                dAST = new ErrorDeclaration(currentToken.position);
                break;
        }

        return dAST;
    }
    
    private Declaration parseDeclaration()
    {
        Declaration d1AST = parseSingleDeclaration();

        while (currentToken.kind == JSToken.SEMICOLON)
        {
            advance();
            Declaration d2AST = parseSingleDeclaration();
            d1AST = new SequentialDeclaration(d1AST, d2AST, d1AST.getPosition());
        }
        return d1AST;
    }

    private Command parseCommand()
    {
        Command c1AST = parseSingleCommand();

        while (currentToken.kind == JSToken.SEMICOLON)
        {
            advance();
            Command c2AST = parseSingleCommand();
            c1AST = new SequentialCommand(c1AST, c2AST, c1AST.getPosition());
        }

        return c1AST;
    }

    private Command parseSingleCommand()
    {
        Command cAST = null;

        switch (currentToken.kind)
        {
            case IDENTIFIER:
                Identifier iAST = parseIdentifier();
                Vname vAST = new SimpleVname(iAST, iAST.getPosition());
                accept(JSToken.BECOMES);
                Expression eAST = parseExpression();
                cAST = new AssignCommand(vAST, eAST, vAST.getPosition());
                break;
            case IF:
                advance();
                Expression condAST = parseExpression();
                Command thenAST = parseSingleCommand();
                accept(JSToken.ELSE);
                Command elseAST = parseSingleCommand();
                cAST = new IfCommand(condAST, thenAST, elseAST, condAST.getPosition());
                break;
            case WHILE:
                advance();
                Expression cond2AST = parseExpression();
                Command bodyAST = parseSingleCommand();
                cAST = new WhileCommand(cond2AST, bodyAST, cond2AST.getPosition());
                break;
            case LET:
                advance();
                accept(JSToken.LPAREN);
                Declaration declAST = parseDeclaration();
                accept(JSToken.RPAREN);
                Command blockAST = parseSingleCommand();
                cAST = new LetCommand(declAST, blockAST, declAST.getPosition());
                break;
            case LCURLY:
                advance();
                cAST = parseCommand();
                accept(JSToken.RCURLY);
                break;
            default:
                cAST = new ErrorCommand(currentToken.position);
                break;
        }

        return cAST;
    }

    private Program parseProgram()
    {
        Command cAST = parseSingleCommand();
        Program progAST = new Program(cAST, cAST.getPosition());
        return progAST;
    }

    public Program parse()
    {
        advance();
        Program progAST = parseProgram();
        accept(JSToken.EOT);
        return progAST;
    }
}