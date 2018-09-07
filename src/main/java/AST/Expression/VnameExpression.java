import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Vname.*;

public class VnameExpression extends Expression
{
    public Vname v;

    public VnameExpression(Vname vn, SourcePosition pos)
    {
        super(pos);
        v = vn;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitVnameExpression(this, o);
    }
}
