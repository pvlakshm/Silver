import SyntaxChecking.SourcePosition;
import AST.*;

public class BoolTypeDenoter extends TypeDenoter
{
    public BoolTypeDenoter(SourcePosition pos)
    {
        super(pos);
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitBoolTypeDenoter(this, o);
    }

    public boolean equals(Object other)
    {
        return (other != null && other instanceof BoolTypeDenoter);
    }
}
