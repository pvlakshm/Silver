import SyntaxChecking.SourcePosition;
import AST.*;

public class IntegerLiteral extends Terminal
{
    public IntegerLiteral(String s, SourcePosition pos)
    {
        super(pos);
        spelling = s;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitIntegerLiteral(this, o);
    }
}
