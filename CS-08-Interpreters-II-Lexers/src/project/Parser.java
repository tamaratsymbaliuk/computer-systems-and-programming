package project;

public class Parser {

    abstract class ASTNode {

    }
    class Number extends ASTNode {
        private final int value;
        Lexer.Token numberToken;

        public Number(Lexer.Token numberToken) {
            this.numberToken = numberToken;
            this.value = Integer.parseInt(numberToken.value);
        }
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
