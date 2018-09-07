import AST.*;
import SyntaxChecking.SourcePosition;

public abstract class Command extends AST
{
    public Command(SourcePosition pos)
    {
        super(pos);
    }
}
