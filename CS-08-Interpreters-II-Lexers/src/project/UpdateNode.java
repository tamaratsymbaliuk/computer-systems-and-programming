package project;

public class UpdateNode extends ASTNode {
    private final CodingHomeworkLexer.Token token;
    private final CodingHomeworkLexer.Token key;
    private final CodingHomeworkLexer.Token value;

    public UpdateNode(CodingHomeworkLexer.Token token, CodingHomeworkLexer.Token key, CodingHomeworkLexer.Token value) {
        this.token = token;
        this.key = key;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Update{" + key.value + " = " + value.value + "}");
    }
}
