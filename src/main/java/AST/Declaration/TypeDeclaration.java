import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Terminal.*;
import AST.TypeDenoter.*;

public class TypeDeclaration extends Declaration
{
    public Identifier  id;
    public TypeDenoter type;

    public TypeDeclaration(Identifier i, TypeDenoter t, SourcePosition pos)
    {
        super(pos);
        id = i;
        type = t;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitTypeDeclaration(this, o);
    }
}
