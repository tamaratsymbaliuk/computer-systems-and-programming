package project;

import java.util.ArrayList;
import java.util.List;

public class LoopNode extends ASTNode {
        private final CodingHomeworkLexer.Token token;
        private final CodingHomeworkLexer.Token variable;
        private final CodingHomeworkLexer.Token fromValue;
        private final CodingHomeworkLexer.Token toValue;
        private final List<ASTNode> body;

        public LoopNode(CodingHomeworkLexer.Token token, CodingHomeworkLexer.Token variable, CodingHomeworkLexer.Token fromValue, CodingHomeworkLexer.Token toValue) {
            this.token = token;
            this.variable = variable;
            this.fromValue = fromValue;
            this.toValue = toValue;
            this.body = new ArrayList<>();
        }

        public void addBodyStatement(ASTNode statement) {
            body.add(statement);
        }

        @Override
        public void print(String indent) {
            System.out.println(indent + "Loop{" + variable.value + " from " + fromValue.value + " to " + toValue.value + "}");
            for (ASTNode statement : body) {
                statement.print(indent + "  ");
            }
            System.out.println(indent + "EndLoop}");
        }
    }

