import SyntaxChecking.SourcePosition;
import AST.*;

public class ErrorTypeDenoter extends TypeDenoter
{
    public ErrorTypeDenoter(SourcePosition pos)
    {
        super(pos);
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitErrorTypeDenoter(this, o);
    }

    public boolean equals(Object other)
    {
        return (other != null && other instanceof ErrorTypeDenoter);
    }
}
