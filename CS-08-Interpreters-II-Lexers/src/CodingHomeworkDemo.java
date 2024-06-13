public class CodingHomeworkDemo {
    public static void main(String[] args) {

        String input = """
                config "num_users" = 100
                config "num_requests" = 100
                update "num_users" = 200
                compute "result" = %num_users + %num_requests
                loop "i" from 1 to 5
                compute "iteration_result_%i" = %num_users * %i
                end
                if %num_users > 1000
                update "status" = "high load"
                else
                update "status" = "normal load"
                end
                """;
        CodingHomeworkLexer lexer = new CodingHomeworkLexer(input);
        for (CodingHomeworkLexer.Token token : lexer) {
            System.out.println(token);
        }
    }
}
