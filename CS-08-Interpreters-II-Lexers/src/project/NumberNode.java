package project;

public class NumberNode extends ASTNode {
    final int value;
    Lexer.Token numberToken;

    public NumberNode(Lexer.Token numberToken) {
        this.numberToken = numberToken;
        this.value = Integer.parseInt(numberToken.value);
    }
}
