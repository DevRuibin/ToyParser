package com.tiny.lexer;

public class Symbol {
    public Token token;
    public String value;
    public int line;
    public int column;

    public Symbol(Token token, String value) {
        this.token = token;
        this.value = value;
    }

    public Symbol(Token token, String value, int line, int column) {
        this.token = token;
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public Symbol(Token token, int line, int column) {
        this.token = token;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "token=" + token +
                ", value='" + value + '\'' +
                '}';
    }
}
