import SyntaxChecking.SourcePosition;
import AST.*;
import AST.TypeDenoter.*;

public abstract class Expression extends AST
{
    public TypeDenoter type;

    public Expression(SourcePosition pos)
    {
        super(pos);
    }
}
