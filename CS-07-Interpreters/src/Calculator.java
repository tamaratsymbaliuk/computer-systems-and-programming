import java.util.Scanner;

public class Calculator {

    // ADD 34 3 (operator operand operand)
    // SUB 31 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String raw_expr = scanner.nextLine();
        String[] expr = raw_expr.split("");
        if(expr.length != 3) {
            throw new IllegalArgumentException("Input doesn't satisfy language rules: " + raw_expr);
        }

        try {
            String operator = expr[0];
            int operand1 = Integer.parseInt(expr[1]);
            int operand2 = Integer.parseInt(expr[2]);
        } catch (Exception e) {
            throw new IllegalArgumentException("We couldn't parse your input", e);
        }

        scanner.close();
    }
}
