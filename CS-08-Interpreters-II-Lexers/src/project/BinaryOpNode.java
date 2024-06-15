package project;

public class BinaryOpNode extends ASTNode {
   ASTNode right;
    ASTNode left;
    Lexer.Token operationToken;

    public BinaryOpNode(ASTNode right, ASTNode left, Lexer.Token operationToken) {
        this.right = right;
        this.left = left;
        this.operationToken = operationToken;
    }
}
