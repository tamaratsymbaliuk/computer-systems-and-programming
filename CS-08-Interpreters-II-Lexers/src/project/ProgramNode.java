package project;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends ASTNode {
    private final List<ASTNode> statements;

    public ProgramNode() {
        this.statements = new ArrayList<>();
    }

    public void addStatement(ASTNode statement) {
        this.statements.add(statement);
    }

    @Override
    public void print(String indent) {
        for (ASTNode statement : statements) {
            statement.print(indent);
        }
    }
}
