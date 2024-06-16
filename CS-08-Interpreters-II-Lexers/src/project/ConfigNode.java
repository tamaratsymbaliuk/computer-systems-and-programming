package project;

public class ConfigNode extends ASTNode {
    private final CodingHomeworkLexer.Token token;
    private final CodingHomeworkLexer.Token key;
    private final CodingHomeworkLexer.Token value;

    public ConfigNode(CodingHomeworkLexer.Token token, CodingHomeworkLexer.Token key, CodingHomeworkLexer.Token value) {
        this.token = token;
        this.key = key;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Config{" + key.value + " = " + value.value + "}");
    }
}
