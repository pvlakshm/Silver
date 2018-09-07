import AST.*;
import SyntaxChecking.SourcePosition;

// indicates a syntax error
public class ErrorDeclaration extends Declaration
{
    public ErrorDeclaration(SourcePosition pos)
    {
        super(pos);
    }

    public Object visit(Visitor v, Object o)
    {
        return null;
    }
}
