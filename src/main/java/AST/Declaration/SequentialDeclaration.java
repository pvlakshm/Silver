import SyntaxChecking.SourcePosition;
import AST.*;

public class SequentialDeclaration extends Declaration
{
    public Declaration decl1;
    public Declaration decl2;

    public SequentialDeclaration(Declaration d1, Declaration d2, SourcePosition pos)
    {
        super(pos);
        decl1 = d1;
        decl2 = d2;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitSequentialDeclaration(this, o);
    }
}
