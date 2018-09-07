import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Declaration.*;

public class Operator extends Terminal
{
    public Declaration decl;

    public Operator(String s, SourcePosition pos)
    {
        super(pos);
        spelling = s;
        decl = null;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitOperator(this, o);
    }
}
