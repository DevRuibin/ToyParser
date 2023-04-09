package com.complex;

import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        InputStreamReader program = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("testValid.txt")));
        Reader reader = new BufferedReader(program);
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        parser.parser();

        program = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("testInvalid.txt")));
        reader = new BufferedReader(program);
        lexer = new Lexer(reader);
        parser = new Parser(lexer);
        try {
            parser.parser();
        } catch (RuntimeException e) {
            assert e.getMessage().equals("Syntax error");
        }
    }
}