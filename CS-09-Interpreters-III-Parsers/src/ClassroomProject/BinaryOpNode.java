package ClassroomProject;

public class BinaryOpNode extends ASTNode {
    ASTNode right;
    ASTNode left;
    Token operationToken;

    public BinaryOpNode(ASTNode right, ASTNode left, Token operationToken) {
        this.right = right;
        this.left = left;
        this.operationToken = operationToken;
    }

    public void print(String indent) {
        System.out.println(indent + "Op{" + operationToken.value + "}");
        left.print(indent + indent);
        right.print(indent + indent);

    }

}
