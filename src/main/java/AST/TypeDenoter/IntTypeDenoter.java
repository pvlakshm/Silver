import SyntaxChecking.SourcePosition;
import AST.*;

public class IntTypeDenoter extends TypeDenoter
{
    public IntTypeDenoter(SourcePosition pos)
    {
        super(pos);
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitIntTypeDenoter(this, o);
    }

    public boolean equals(Object other)
    {
        return (other != null && other instanceof IntTypeDenoter);
    }
}
