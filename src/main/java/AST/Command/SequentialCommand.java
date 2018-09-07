import SyntaxChecking.SourcePosition;
import AST.*;

public class SequentialCommand extends Command
{
    public Command c1;
    public Command c2;

    public SequentialCommand(Command cmd1, Command cmd2, SourcePosition pos)
    {
        super(pos);
        c1 = cmd1;
        c2 = cmd2;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitSequentialCommand(this, o);
    }
}
