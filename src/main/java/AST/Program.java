import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Command.*;


public class Program extends AST
{
    public Command c;  // program body

    public Program(Command cmd, SourcePosition pos)
    {
        super(pos);
        c = cmd;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitProgram(this, null);
    }
}