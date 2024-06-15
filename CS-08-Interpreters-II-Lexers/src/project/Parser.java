package project;

public class Parser {

    abstract class ASTNode {

    }
    class Number extends ASTNode {

    }

    class BinaryOp extends ASTNode {
        ASTNode right;
        ASTNode left;
        Lexer.Token operationToken;

        public BinaryOp(ASTNode right, ASTNode left, Lexer.Token operationToken) {
            this.right = right;
            this.left = left;
            this.operationToken = operationToken;
        }
    }
}
