package project;

public class StringNode extends ASTNode {
    CodingHomeworkLexer.Token token;
    public StringNode(CodingHomeworkLexer.Token token) {
        this.token = token;
    }
   /* @Override
    public String toString() {
        return "StringNode{" +
                "token=" + token +
                '}';
    }*/

    @Override
    public void print(String indent) {

    }
}
