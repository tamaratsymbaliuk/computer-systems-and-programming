package project;

public class Token {
    public enum Type {
        CONFIG, UPDATE, COMPUTE, SHOW, CONFIGS, STRING, NUMBER, IDENTIFIER, ASSIGNMENT, REFERENCES, OPERATOR, MULTIPLY, DIVIDE

    }
        public final Type type;
        public final String value;

        public Token(Type type, String value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
}
