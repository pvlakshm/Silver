import SyntaxChecking.SourcePosition;
import AST.*;
import AST.TypeDenoter.*;

public abstract class Vname extends AST
{
    public boolean variable;
    public TypeDenoter type;

    public Vname(SourcePosition pos)
    {
        super(pos);
        variable = false;
        type = null;
    }
}
