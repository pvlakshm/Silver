import SyntaxChecking.SourcePosition;
import AST.*;

public abstract class TypeDenoter extends AST
{
    public TypeDenoter(SourcePosition pos)
    {
        super(pos);
    }

    public abstract boolean equals(Object other);
}
