package ClassroomProject;

import java.util.List;

public class Demo {
    public static void main(String[] args) {

       String input = """
                {
                var x = 6;
                {
                var y = 4;
                }
                }
                """;
        Lexer lexer = new Lexer(input);
        for (Token token: lexer) {
            System.out.println(token);
        }
        List<Token> tokens = lexer.getTokens();
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();
        root.print("   ");

    }

}