import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Terminal.*;

public class SimpleTypeDenoter extends TypeDenoter
{
    public Identifier i;

    public SimpleTypeDenoter(Identifier id, SourcePosition pos)
    {
        super(pos);
        i = id;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitSimpleTypeDenoter(this, o);
    }

    public boolean equals(Object other)
    {
        // should never get called.
        return false;
    }
}