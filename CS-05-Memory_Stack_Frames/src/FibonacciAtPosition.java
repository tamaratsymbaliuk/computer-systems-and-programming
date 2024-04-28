public class FibonacciAtPosition {

    //bad implementation
    public static int fibonacci (int n){
        if (n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
