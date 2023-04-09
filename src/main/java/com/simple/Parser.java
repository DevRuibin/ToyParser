package com.simple;

import java.io.IOException;

public class Parser {
    Symbol lookahead;
    Lexer lexer;
    public Parser(Lexer lexer) throws IOException {
        this.lexer = lexer;
        lookahead = lexer.getNextSymbol();
    }

    public Symbol match(Token token) throws IOException {
        Symbol matched;
        if (lookahead.token == token) {
            matched = lookahead;
            lookahead = lexer.getNextSymbol();
        } else {
            throw new RuntimeException("Syntax error");
        }
        return matched;
    }

    public void parser() throws IOException {
        match(Token.a);
        match(Token.b);
        match(Token.a);
        match(Token.END);
    }
}
