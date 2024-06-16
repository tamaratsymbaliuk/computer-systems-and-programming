package project;

public class BinaryOpNodeHW extends ASTNode {
    ASTNode right;
    ASTNode left;
    CodingHomeworkLexer.Token operationToken;


    public BinaryOpNodeHW(ASTNode right, ASTNode left, CodingHomeworkLexer.Token operationToken) {
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

