public class Demo {
    public static void main(String[] args) {

        String input = """
                config "num_users" = 100
                config "num_requests" = 100
                update "num_users" = 200
                compute "result" = %num_users + %num_requests
                """;
        Lexer lexer = new Lexer(input);
        for (Lexer.Token token: lexer) {
            System.out.println(token);
        }

//        ArrayList<Lexer.Token> tokens = new ArrayList<>();
//        tokens.add(new Lexer.Token(Lexer.TokenType.CONFIG, "Config"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.STRING, "num_users"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.ASSIGNMENT, "="));
//        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBER, "100"));
//
//        for (Lexer.Token token: tokens) {
//            System.out.println(token);
//        }
    }

}