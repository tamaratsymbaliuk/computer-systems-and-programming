package project;

public class ComputeNode extends ASTNode {
    private final CodingHomeworkLexer.Token token;
    private final CodingHomeworkLexer.Token key;
    private final ASTNode expression;

    public ComputeNode(CodingHomeworkLexer.Token token, CodingHomeworkLexer.Token key, ASTNode expression) {
        this.token = token;
        this.key = key;
        this.expression = expression;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Compute{" + key.value + " = ");
        expression.print(indent + "  ");
        System.out.println(indent + "}");
    }
}
