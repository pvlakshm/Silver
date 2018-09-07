import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Terminal.*;
import AST.TypeDenoter.*;

public class VarDeclaration extends Declaration
{
    public Identifier  id;
    public TypeDenoter type;

    public VarDeclaration(Identifier i, TypeDenoter t, SourcePosition pos)
    {
        super(pos);
        id = i;
        type = t;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitVarDeclaration(this, o);
    }
}
