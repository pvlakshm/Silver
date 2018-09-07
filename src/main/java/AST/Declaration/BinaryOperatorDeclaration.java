import SyntaxChecking.SourcePosition;
import AST.*;
import AST.Terminal.*;
import AST.TypeDenoter.*;

// used only during semantic analysis
public class BinaryOperatorDeclaration extends Declaration
{
    public BinaryOperatorDeclaration(
                Operator o,
                TypeDenoter t1AST, TypeDenoter t2AST, TypeDenoter rAST,
                SourcePosition pos)
    {
        super(pos);
        op = o;
        lop = t1AST;
        rop = t2AST;
        res = rAST;
    }

    public Object visit(Visitor v, Object o)
    {
        return v.visitBinaryOperatorDeclaration(this, o);
    }

    public Operator     op;
    public TypeDenoter  lop;
    public TypeDenoter  rop;
    public TypeDenoter  res;
}
