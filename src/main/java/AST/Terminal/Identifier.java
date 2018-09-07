import SyntaxChecking.SourcePosition;
import AST.*;
import AST.TypeDenoter.*;

public class Identifier extends Terminal
{
    public TypeDenoter  type;
    public AST          decl; // a Declaration

    public Identifier(String s, SourcePosition pos)
    {
        super(pos);
        spelling = s;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitIdentifier(this, o);
    }
}