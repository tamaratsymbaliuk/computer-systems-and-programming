package ClassroomProject;

import java.sql.SQLOutput;

public class VarDecl extends  ASTNode {
    Var varNode;
    ASTNode expr;

    VarDecl(Var varNode, ASTNode expr) {
        this.varNode = varNode;
        this.expr = expr;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "VarDecl{" + varNode.name + "}");
        expr.print(indent + indent);
    }


}
