package com.simple;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        String program = "a b a"; // a b a is a valid program
        Reader reader = new StringReader(program);
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        parser.parser();

        program = "a b b"; // a b b is not a valid program
        reader = new StringReader(program);
        lexer = new Lexer(reader);
        parser = new Parser(lexer);
        try {
            parser.parser();
        } catch (RuntimeException e) {
            assert e.getMessage().equals("Syntax error");
        }
    }
}