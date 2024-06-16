package project;

import java.util.List;

public class CodingHomeworkParser {
    private final List<CodingHomeworkLexer.Token> tokens;
    private int currentPos;
    private CodingHomeworkLexer.Token currentToken;

    public CodingHomeworkParser(List<CodingHomeworkLexer.Token> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        if (!tokens.isEmpty()) {
            this.currentToken = tokens.get(currentPos);
        } else {
            this.currentToken = null;
        }
    }

    public ASTNode parse() {
        return program();
    }

    private ASTNode program() {
        ProgramNode node = new ProgramNode();
        while (currentToken != null) {
            node.addStatement(statement());
        }
        return node;
    }

    private ASTNode statement() {
        switch (currentToken.type) {
            case CONFIG:
                return configStatement();
            case UPDATE:
                return updateStatement();
            case COMPUTE:
                return computeStatement();
            case LOOP:
                return loopStatement();
            case IF:
                return ifStatement();
            default:
                throw new ParserException("Unexpected token found: " + currentToken);
        }
    }

    private ASTNode configStatement() {
        CodingHomeworkLexer.Token token = currentToken;
        consume(CodingHomeworkLexer.TokenType.CONFIG);
        CodingHomeworkLexer.Token key = currentToken;
        consume(CodingHomeworkLexer.TokenType.STRING);
        consume(CodingHomeworkLexer.TokenType.ASSIGNMENT);
        CodingHomeworkLexer.Token value = currentToken;
        consume(CodingHomeworkLexer.TokenType.NUMBER);
        return new ConfigNode(token, key, value);
    }

    private ASTNode updateStatement() {
        CodingHomeworkLexer.Token token = currentToken;
        consume(CodingHomeworkLexer.TokenType.UPDATE);
        CodingHomeworkLexer.Token key = currentToken;
        consume(CodingHomeworkLexer.TokenType.STRING);
        consume(CodingHomeworkLexer.TokenType.ASSIGNMENT);
        CodingHomeworkLexer.Token value = currentToken;
        if (value.type == CodingHomeworkLexer.TokenType.NUMBER || value.type == CodingHomeworkLexer.TokenType.STRING) {
            consume(value.type);
        } else {
            throw new ParserException("Unexpected token in update statement: " + value);
        }
        return new UpdateNode(token, key, value);
    }

    private ASTNode computeStatement() {
        CodingHomeworkLexer.Token token = currentToken;
        consume(CodingHomeworkLexer.TokenType.COMPUTE);
        CodingHomeworkLexer.Token key = currentToken;
        consume(CodingHomeworkLexer.TokenType.STRING);
        consume(CodingHomeworkLexer.TokenType.ASSIGNMENT);
        ASTNode expression = expression();
        return new ComputeNode(token, key, expression);
    }

    private ASTNode loopStatement() {
        CodingHomeworkLexer.Token token = currentToken;
        consume(CodingHomeworkLexer.TokenType.LOOP);
        CodingHomeworkLexer.Token variable = currentToken;
        consume(CodingHomeworkLexer.TokenType.STRING);
        consume(CodingHomeworkLexer.TokenType.FROM);
        CodingHomeworkLexer.Token fromValue = currentToken;
        consume(CodingHomeworkLexer.TokenType.NUMBER);
        consume(CodingHomeworkLexer.TokenType.TO);
        CodingHomeworkLexer.Token toValue = currentToken;
        consume(CodingHomeworkLexer.TokenType.NUMBER);
        LoopNode loopNode = new LoopNode(token, variable, fromValue, toValue);
        while (currentToken != null && currentToken.type != CodingHomeworkLexer.TokenType.END) {
            loopNode.addBodyStatement(statement());
        }
        consume(CodingHomeworkLexer.TokenType.END);
        return loopNode;
    }

    private ASTNode ifStatement() {
        CodingHomeworkLexer.Token token = currentToken;
        consume(CodingHomeworkLexer.TokenType.IF);
        ASTNode condition = booleanExpression();
        IfNode ifNode = new IfNode(token, condition);
        while (currentToken != null && currentToken.type != CodingHomeworkLexer.TokenType.END && currentToken.type != CodingHomeworkLexer.TokenType.ELSE) {
            ifNode.addIfBodyStatement(statement());
        }
        if (currentToken != null && currentToken.type == CodingHomeworkLexer.TokenType.ELSE) {
            consume(CodingHomeworkLexer.TokenType.ELSE);
            while (currentToken != null && currentToken.type != CodingHomeworkLexer.TokenType.END) {
                ifNode.addElseBodyStatement(statement());
            }
        }
        consume(CodingHomeworkLexer.TokenType.END);
        return ifNode;
    }

    private ASTNode booleanExpression() {
        ASTNode node = expression();
        if (currentToken != null && isRelationalOperator(currentToken.type)) {
            CodingHomeworkLexer.Token operatorToken = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNodeHW(node, expression(), operatorToken);
        }
        return node;
    }

    private boolean isRelationalOperator(CodingHomeworkLexer.TokenType type) {
        return type == CodingHomeworkLexer.TokenType.OPERATOR;
    }

    private ASTNode expression() {
        ASTNode node = term();
        while (currentToken != null && (currentToken.type == CodingHomeworkLexer.TokenType.OPERATOR && (currentToken.value.equals("+") || currentToken.value.equals("-")))) {
            CodingHomeworkLexer.Token token = currentToken;
            consume(CodingHomeworkLexer.TokenType.OPERATOR);
            node = new BinaryOpNodeHW(node, term(), token);
        }
        return node;
    }

    private ASTNode term() {
        ASTNode node = factor();
        while (currentToken != null && (currentToken.type == CodingHomeworkLexer.TokenType.OPERATOR && (currentToken.value.equals("*") || currentToken.value.equals("/")))) {
            CodingHomeworkLexer.Token token = currentToken;
            consume(CodingHomeworkLexer.TokenType.OPERATOR);
            node = new BinaryOpNodeHW(node, factor(), token);
        }
        return node;
    }

    private ASTNode factor() {
        CodingHomeworkLexer.Token token = currentToken;
        if (token.type == CodingHomeworkLexer.TokenType.NUMBER) {
            consume(CodingHomeworkLexer.TokenType.NUMBER);
            return new NumberNodeHW(token);
        } else if (token.type == CodingHomeworkLexer.TokenType.STRING) {
            consume(CodingHomeworkLexer.TokenType.STRING);
            return new StringNode(token);
        } else if (token.type == CodingHomeworkLexer.TokenType.REFERENCES) {
            consume(CodingHomeworkLexer.TokenType.REFERENCES);
            return new ReferenceNode(token);
        } else if (token.type == CodingHomeworkLexer.TokenType.LPAREN) {
            consume(CodingHomeworkLexer.TokenType.LPAREN);
            ASTNode node = expression();
            consume(CodingHomeworkLexer.TokenType.RPAREN);
            return node;
        } else {
            throw new ParserException("Unexpected token found for Factor: " + token);
        }
    }

    private void consume(CodingHomeworkLexer.TokenType type) {
        if (currentToken != null && currentToken.type == type) {
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
}
