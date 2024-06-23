package ClassroomProject;

import java.util.List;

public class Demo {
    public static void main(String[] args) {

       String input = """
                3 + 5 * (10 - 1);
                var x = 4 - 5;
                x = 1
                """;
        Lexer lexer = new Lexer(input);
        for (Token token: lexer) {
            System.out.println(token);
        }
        List<Token> tokens = lexer.getTokens();
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();
        root.print("   ");

        /*System.out.println("Second example");
        String input1 = """
                3 * 5 * 10 * 4
                """;
        Lexer lexer1 = new Lexer(input1);

         */
      //  List<Token> tokens = Lexer.getHardcodedTokens();
        // List<Token> tokens = new ArrayList<Token>();
        /*for (Token token: lexer1) {
            //   tokens.add(token);
            System.out.println(token);
        }


         */


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