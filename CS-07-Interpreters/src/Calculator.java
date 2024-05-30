import java.util.Scanner;

public class Calculator {

    // ADD 34 3 (operator operand operand)
    // SUB 31 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String raw_expr = scanner.nextLine();
            if ("quit".equalsIgnoreCase(raw_expr)) break;
            String[] expr = raw_expr.split(" ");
            if (expr.length != 3) {
                throw new IllegalArgumentException("Input doesn't satisfy language rules: " + raw_expr);
            }


        try {
            String operator = expr[0];
            double operand1 = Double.parseDouble(expr[1]);
            double operand2 = Double.parseDouble(expr[2]);

            double result = evaluate(operator, operand1, operand2);
            System.out.println(result);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

        scanner.close();
    }

    private static double evaluate(String operator, double operand1, double operand2) {
        switch (operator) {
            case "ADD":
                return operand1 + operand2;
            case "SUB":
                return operand1 - operand2;
            case "MUL":
                return operand1 * operand2;
            case "DIV":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not supported");
                }
                return operand1 / operand2;
            case "MOD":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Modulo by zero is not supported");
                }
                return operand1 % operand2;
            case "POW":
                return Math.pow(operand1, operand2);
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + operator);
        }

    }
}
