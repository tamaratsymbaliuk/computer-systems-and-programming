package project;

import java.util.List;

public class Parser {
    private final List<Lexer.Token> tokens;
    private int currentPos;
    private Lexer.Token currentToken;
    Parser(List<Lexer.Token> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }

    public ASTNode parse() {
        return term();
    }

    private ASTNode term() {
        ASTNode factor = factor();

        while ()

    }

    private ASTNode factor() {
        return null;
    }

}
