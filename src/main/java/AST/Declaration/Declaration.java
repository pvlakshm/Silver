import SyntaxChecking.SourcePosition;
import AST.*;

public abstract class Declaration extends AST
{
    public Declaration(SourcePosition pos)
    {
        super(pos);
        duplicated = false;
    }

    public boolean duplicated;
}
