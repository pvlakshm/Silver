import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Command.*;
import AST.Expression.*;

public class IfCommand extends Command
{
    public Expression   E;
    public Command      C1;
    public Command      C2;

    public IfCommand(Expression e, Command c1, Command c2, SourcePosition pos)
    {
        super(pos);
        E = e;
        C1 = c1;
        C2 = c2;
    }
    
    public Object visit(Visitor v, Object o)
    {
        return v.visitIfCommand(this, o);
    }    
}
