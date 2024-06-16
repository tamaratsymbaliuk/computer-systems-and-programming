package project;

import java.util.ArrayList;
import java.util.List;

public class IfNode extends ASTNode {
    private final CodingHomeworkLexer.Token token;
    private final ASTNode condition;
    private final List<ASTNode> ifBody;
    private final List<ASTNode> elseBody;

    public IfNode(CodingHomeworkLexer.Token token, ASTNode condition) {
        this.token = token;
        this.condition = condition;
        this.ifBody = new ArrayList<>();
        this.elseBody = new ArrayList<>();
    }

    public void addIfBodyStatement(ASTNode statement) {
        ifBody.add(statement);
    }

    public void addElseBodyStatement(ASTNode statement) {
        elseBody.add(statement);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "If{" + condition + "}");
        for (ASTNode statement : ifBody) {
            statement.print(indent + "  ");
        }
        if (!elseBody.isEmpty()) {
            System.out.println(indent + "Else{");
            for (ASTNode statement : elseBody) {
                statement.print(indent + "  ");
            }
            System.out.println(indent + "}");
        }
        System.out.println(indent + "EndIf}");
    }
}
