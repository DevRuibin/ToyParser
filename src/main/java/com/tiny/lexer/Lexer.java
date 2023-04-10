package com.tiny.lexer;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.Reader;

public class Lexer {
    private final Reader reader;
    private char currentChar;
    private int currentLine;
    private int currentColumn;
    private String currentState = "0";

    private char oldChar = (char) -1;



    public Lexer(Reader reader) throws Exception {
        this.reader = reader;
        currentLine = 1;
        currentColumn = 1;
    }

    private void read(StringBuilder sb) throws IOException {
        sb.append(currentChar);
        currentChar = (char) reader.read();
        if(currentChar == '\t'){
            currentColumn += 4;
        } else if(currentChar == 'n'){
            currentLine += 1;
            currentColumn = 1;
        }else {
            currentColumn += 1;
        }
    }

    private void changeState(StringBuilder sb, String newState) throws IOException {
        read(sb);
        currentState = newState;
    }

    public Symbol getNextSymbol() throws IOException {
        Symbol symbol = null;
        StringBuilder sb = new StringBuilder();
        read(sb);
        while (currentChar != -1){
            switch (currentState){
                case "0" ->{
                    boolean f1 = currentChar == '_';
                    boolean f2 = currentChar >= 'A' && currentChar <= 'Z';
                    boolean f3 = currentChar >= 'a' && currentChar <= 'e';
                    boolean f4 = currentChar >= 'g' && currentChar <= 'h';
                    boolean f5 = currentChar >= 'j' && currentChar <= 'o';
                    boolean f6 = currentChar == 'q';
                    boolean f7 = currentChar >= 's' && currentChar <= 'z';
                    if(f1 || f2 || f3 || f4 || f5 || f6 || f7){
                        read(sb);
                        currentState = "id";
                        break;
                    }

                    if(currentChar >= '1' && currentChar <= '9'){
                        read(sb);
                        currentState = "int_num2";
                        break;
                    }

                    switch (currentChar){
                        case '0' -> {
                            read(sb);
                            currentState = "int_num1";
                        }
                        case ';' -> changeState(sb, "9");
                        case '(' -> changeState(sb, "10");
                        case ')' -> changeState(sb, "11");
                        case '{' -> changeState(sb, "12");
                        case '}' -> changeState(sb, "13");
                        case ',' -> changeState(sb, "14");
                        case '=' -> changeState(sb, "15");
                        case '+' -> changeState(sb, "16");
                        case '-' -> changeState(sb, "17");
                        case '*' -> changeState(sb, "18");
                        case '/' -> changeState(sb, "19");
                        case '\n', ' ', '\t' -> changeState(sb, "white");
                        case 'f' -> changeState(sb, "1");
                        case 'w' -> changeState(sb, "20");
                    }
                }
                case "int_num2" ->{

                }
                case "int_num1" ->{

                }
                case "9" ->{

                }
                case "10" ->{

                }
                case "11" ->{

                }
                case "12" ->{

                }
                case "13" ->{

                }
                case "14" ->{

                }
                case "15" ->{

                }
                case "16" ->{

                }
                case "17" ->{

                }
                case "18" ->{

                }
                case "19" ->{

                }
                case "while" ->{

                }
                case "1" ->{

                }
                case "20" ->{

                }
                case "4" ->{

                }
                case "28" ->{

                }
                case "22" ->{

                }
            }
        }


        return symbol;
    }


}
