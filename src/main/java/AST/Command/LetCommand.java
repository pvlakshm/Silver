import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Declaration.*;

public class LetCommand extends Command
{
    public Declaration  D;
    public Command      C;

    public LetCommand(Declaration d, Command c, SourcePosition pos)
    {
        super(pos);
        D = d;
        C = c;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitLetCommand(this, o);
    }
}
