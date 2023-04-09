package com.simple;

import java.io.IOException;
import java.io.Reader;

enum Token { a, b, END };
class Symbol {
    Token token;
    Object attribute; // not needed for this simple example
}
public class Lexer {
    private final Reader reader;
    public Lexer(Reader reader){
        this.reader = reader;
    }
    public Symbol getNextSymbol() throws IOException {
        char c = (char) reader.read();
        if(c == ' ' || c == '\t' || c == '\n') return getNextSymbol();
        if(c == 'a') return new Symbol() {{ token = Token.a; }};
        if(c == 'b') return new Symbol() {{ token = Token.b; }};
        return new Symbol() {{ token = Token.END; }};
    }
}