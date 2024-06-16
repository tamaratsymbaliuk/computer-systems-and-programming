package project;

public class NumberNodeHW extends ASTNode {
    final int value;
    CodingHomeworkLexer.Token numberToken;

    public NumberNodeHW(CodingHomeworkLexer.Token numberToken) {
        this.numberToken = numberToken;
        this.value = Integer.parseInt(numberToken.value);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "N{" + value + '}');
    }
}
