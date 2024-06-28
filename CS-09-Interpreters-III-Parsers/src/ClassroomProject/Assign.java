package ClassroomProject;

public class Assign extends ASTNode {
    public Var left;
    public ASTNode right;

    Assign (Var left, ASTNode right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public void print(String indent) {

    }


}
