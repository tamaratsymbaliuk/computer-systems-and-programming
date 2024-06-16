package project;

public class ReferenceNode extends ASTNode {
    CodingHomeworkLexer.Token token;
    public ReferenceNode(CodingHomeworkLexer.Token token) {
        this.token = token;
    }

    @Override
    public void print(String indent) {

    }
}
