import AST.*;
import SyntaxChecking.SourcePosition;

// indicates a syntax error
public class ErrorCommand extends Command
{
    public ErrorCommand(SourcePosition pos)
    {
        super(pos);
    }

    public Object visit(Visitor v, Object o)
    {
        return null;
    }
}
