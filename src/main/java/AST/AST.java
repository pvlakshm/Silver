import SyntaxChecking.SourcePosition;

public abstract class AST
{
    private SourcePosition pos;

    public AST(SourcePosition p)
    {
        pos = p;
    }

    public SourcePosition getPosition()
    {
        return pos;
    }

    public abstract Object visit(Visitor v, Object o);
}