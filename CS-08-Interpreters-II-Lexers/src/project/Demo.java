package project;

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

//        ArrayList<project.Lexer.Token> tokens = new ArrayList<>();
//        tokens.add(new project.Lexer.Token(project.Lexer.TokenType.CONFIG, "Config"));
//        tokens.add(new project.Lexer.Token(project.Lexer.TokenType.STRING, "num_users"));
//        tokens.add(new project.Lexer.Token(project.Lexer.TokenType.ASSIGNMENT, "="));
//        tokens.add(new project.Lexer.Token(project.Lexer.TokenType.NUMBER, "100"));
//
//        for (project.Lexer.Token token: tokens) {
//            System.out.println(token);
//        }
    }

}