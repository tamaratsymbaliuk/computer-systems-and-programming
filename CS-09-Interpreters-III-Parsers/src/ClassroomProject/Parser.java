package ClassroomProject;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int currentPos;
    private Token currentToken;
    Parser(List<Token> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }

    public ASTNode parse() {
        List<ASTNode> statements = new ArrayList<>();
        while (currentToken != null){
            statements.add(statement());
            if (currentToken != null && currentToken.type == Token.Type.SEMICOLON) {
                consume(currentToken.type);
            }
        }
        return new Block(statements);
    }

    private ASTNode statement() {
        if (currentToken.type == Token.Type.LBRACE) {// block is starting
            return block();
        }
        if (currentToken.type == Token.Type.VAR) { // starts declaration
            return declaration();
        }
        if (currentToken.type == Token.Type.IDENTIFIER) { // starts assignment
            return assignment();
        }
        return expression();
    }

    private ASTNode declaration() {
        consume(Token.Type.VAR);
        return null;
    }

    private ASTNode block() {
        consume(Token.Type.LBRACE);
        ArrayList<ASTNode> statements = new ArrayList<>();
        while (currentToken.type != Token.Type.RBRACE) {
            statements.add(statement());
            if (currentToken.type == Token.Type.SEMICOLON) {
                consume(currentToken.type);
            }
        }
        consume(Token.Type.RBRACE);
        return new Block(statements);
    }

    private ASTNode expression() {
        ASTNode node = term();

        while (currentToken != null && (currentToken.type == Token.Type.PLUS || currentToken.type == Token.Type.MINUS)) {
            Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, term(), token);
        }
        return node;

    }

    private ASTNode term() {
        ASTNode node = factor();

        while (currentToken != null && (currentToken.type == Token.Type.MULTIPLY || currentToken.type == Token.Type.DIVIDE)) {
            Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, factor(), token);
        }
        return node;
    }

    private void consume(Token.Type type) {
        if (currentToken.type == type) {
            currentPos++;
            if (currentPos < tokens.size()) {
                currentToken = tokens.get(currentPos);
            } else {
                currentToken = null;
            }

        } else {
            throw new ParserException("Unexpected token: " + currentToken + " expected: " + type);
        }
    }

    private ASTNode factor() {
        Token token = currentToken;

        if (token.type == Token.Type.NUMBER) {
            consume(Token.Type.NUMBER);
            return new NumberNode(token);
        }
        if (token.type == Token.Type.LPAREN) {
            consume(Token.Type.LPAREN);
            ASTNode node = expression();
            consume(Token.Type.RPAREN);
            return node;

        }
        throw new ParserException("Unexpected token found for Factor: " + token);
    }

}

