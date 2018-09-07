import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Vname.*;
import AST.Expression.*;

public class AssignCommand extends Command
{
    public Vname        V;
    public Expression   E;

    public AssignCommand(Vname v, Expression e, SourcePosition pos)
    {
        super(pos);
        V = v;
        E = e;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitAssignCommand(this, o);
    }
}
