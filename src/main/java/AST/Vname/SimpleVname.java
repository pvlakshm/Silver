import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Terminal.*;

public class SimpleVname extends Vname
{
    public Identifier i;

    public SimpleVname(Identifier id, SourcePosition pos)
    {
        super(pos);
        i = id;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitSimpleVname(this, null);
    }
}
