import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Expression.*;
import AST.Terminal.*;

public class ConstDeclaration extends Declaration
{
    public Identifier id;
    public Expression e;

    public ConstDeclaration(Identifier i, Expression ex, SourcePosition pos)
    {
        super(pos);
        id = i;
        e = ex;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitConstDeclaration(this, o);
    }
}