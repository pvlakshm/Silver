import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Terminal.*;

public class BinaryExpression extends Expression
{
    public Expression lop;  // left operand
    public Operator   op;   // operator
    public Expression rop;  // right operand

    public BinaryExpression(Expression e1, Operator o, Expression e2, SourcePosition pos)
    {
        super(pos);
        lop = e1;
        op = o;
        rop = e2;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitBinaryExpression(this, o);
    }
}
