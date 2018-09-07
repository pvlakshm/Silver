import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Command.*;
import AST.Expression.*;

public class WhileCommand extends Command
{
    public Expression E;
    public Command    C;

    public WhileCommand(Expression e, Command c, SourcePosition pos)
    {
        super(pos);
        E = e;
        C = c;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitWhileCommand(this, o);
    }
}