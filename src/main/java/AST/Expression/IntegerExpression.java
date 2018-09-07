import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Terminal.*;

public class IntegerExpression extends Expression
{
    public IntegerLiteral il;

    public IntegerExpression(IntegerLiteral i, SourcePosition pos)
    {
        super(pos);
        il = i;
    }
    
    public Object visit(Visitor v, Object o)
    {
        return v.visitIntegerExpression(this, o);
    }
}