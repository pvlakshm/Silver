import AST.*;
import SyntaxChecking.SourcePosition;

public class ErrorExpression extends Expression
{
    public ErrorExpression(SourcePosition pos)
    {
        super(pos);
    }

    public Object visit(Visitor v, Object o)
    {
        return null;
    }
}
