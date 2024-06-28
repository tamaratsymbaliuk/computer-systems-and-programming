package ClassroomProject;

import java.util.Set;
import java.util.Stack;

public class SemanticAnalyzer {
    private final Stack<Set<String>> scopes = new Stack<>();

    void visit(ASTNode node) {
        if (node instanceof BinaryOpNode) {
            visit(((BinaryOpNode)node).left);
            visit(((BinaryOpNode)node).right);

        } else if (node instanceof NumberNode) {

        } else if (node instanceof VarDecl) {


        } else if (node instanceof Var) {

        } else if (node instanceof Block) {

        } else if (node instanceof Assign) {

        } else {
                throw new ParserException("Unexpected AST Node: " + node.getClass().getCanonicalName());
            }
        }
    }



