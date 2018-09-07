import SyntaxChecking.SourcePosition;
import AST.*;

public abstract class Terminal extends AST
{
    public String spelling;

    public Terminal(SourcePosition pos)
    {
        super(pos);
    }
}
