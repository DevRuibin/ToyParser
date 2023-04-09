package com.complex;

import java.io.IOException;
import java.io.Reader;

enum Token {
    RETURN, SEMICOLON, LPAREN, RPAREN, LBRACE, RBRACE, COMMA,
    IDENTIFIER, INT, FLOAT, ADD, Minus,END
}
class Symbol {
    Token token;
    Object attribute;

    public Object getAttribute() {
        return attribute;
    }

    public Token getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "token=" + token +
                ", attribute=" + attribute +
                '}';
    }
}
public class Lexer {
    private final Reader reader;
    private Character oldChar;
    public Lexer(Reader reader){
        this.reader = reader;
        oldChar = (char) -1;
    }
    public Symbol getNextSymbol() throws IOException {
        char c;
        if(oldChar != (char) -1) {
            c = oldChar;
            oldChar = (char) -1;
        }else {
            c = (char) reader.read();
        }
        if(c == ' ' || c == '\t' || c == '\n') return getNextSymbol();
        if(c == '(') return new Symbol() {{ token = Token.LPAREN; }};
        if(c == ')') return new Symbol() {{ token = Token.RPAREN; }};
        if(c == '{') return new Symbol() {{ token = Token.LBRACE; }};
        if(c == '}') return new Symbol() {{ token = Token.RBRACE; }};
        if(c == ',') return new Symbol() {{ token = Token.COMMA; }};
        if(c == ';') return new Symbol() {{ token = Token.SEMICOLON; }};
        if(c == '+') return new Symbol() {{ token = Token.ADD; }};
        if(c == '-') return new Symbol() {{ token = Token.Minus; }};
        if(c == 'i') {
            c = (char) reader.read();
            if(c == 'n') {
                c = (char) reader.read();
                if(c == 't') {
                    return new Symbol() {{ token = Token.INT; }};
                }
            }
        }
        if(c == 'f') {
            c = (char) reader.read();
            if(c != 'l') {
                oldChar = c;
                return new Symbol() {{ token = Token.IDENTIFIER; attribute = "f"; }};
            }
            c = (char) reader.read();
            if(c == 'o') {
                c = (char) reader.read();
                if(c == 'a') {
                    c = (char) reader.read();
                    if(c == 't') {
                        return new Symbol() {{ token = Token.FLOAT; }};
                    }
                }
            }
        }

        if(c == 'r') {
            c = (char) reader.read();
            if(c == 'e') {
                c = (char) reader.read();
                if(c == 't') {
                    c = (char) reader.read();
                    if(c == 'u') {
                        c = (char) reader.read();
                        if(c == 'r') {
                            c = (char) reader.read();
                            if(c == 'n') {
                                return new Symbol() {{ token = Token.RETURN; }};
                            }
                        }
                    }
                }
            }
        }

        if(c == 'a'){
            return new Symbol() {{ token = Token.IDENTIFIER; attribute = "a"; }};
        }
        if(c == 'b'){
            return new Symbol() {{ token = Token.IDENTIFIER; attribute = "b"; }};
        }

        return new Symbol() {{ token = Token.END; }};

    }
}