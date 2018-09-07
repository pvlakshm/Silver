import AST.Command.*;
import AST.Declaration.*;
import AST.Expression.*;
import AST.Terminal.*;
import AST.TypeDenoter.*;
import AST.Vname.*;

public interface Visitor {
    // program
    public Object visitProgram(Program p, Object o);

    // commands
    public Object visitSequentialCommand(SequentialCommand c, Object o);
    public Object visitAssignCommand(AssignCommand c, Object o);
    public Object visitLetCommand(LetCommand c, Object o);
    public Object visitWhileCommand(WhileCommand c, Object o);
    public Object visitIfCommand(IfCommand c, Object o);

    // declarations
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration d, Object o);
    public Object visitSequentialDeclaration(SequentialDeclaration d, Object o);
    public Object visitConstDeclaration(ConstDeclaration d, Object o);
    public Object visitVarDeclaration(VarDeclaration d, Object o);
    public Object visitTypeDeclaration(TypeDeclaration d, Object o);

    // expressions
    public Object visitBinaryExpression(BinaryExpression e, Object o);
    public Object visitVnameExpression(VnameExpression e, Object o);
    public Object visitIntegerExpression(IntegerExpression e, Object o);

    // terminals
    public Object visitIdentifier(Identifier t, Object o);
    public Object visitIntegerLiteral(IntegerLiteral t, Object o);
    public Object visitOperator(Operator t, Object o);
    
    // type denoter
    public Object visitSimpleTypeDenoter(SimpleTypeDenoter t, Object o);
    public Object visitIntTypeDenoter(IntTypeDenoter t, Object o);
    public Object visitBoolTypeDenoter(BoolTypeDenoter t, Object o);
    public Object visitErrorTypeDenoter(ErrorTypeDenoter t, Object o);

    // Vname
    public Object visitSimpleVname(SimpleVname n, Object o);
}
