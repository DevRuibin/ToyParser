package com.complex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public Function parser() throws IOException {
        Function function = parserFunction();
        match(Token.END);
        return function;
    }

    public List<Param> parserParamList() throws IOException {
        List<Param> params = new ArrayList<>();
        while (lookahead.token != Token.RPAREN) {
            params.add(parserParam());
            if (lookahead.token == Token.COMMA) {
                match(Token.COMMA);
            }else if (lookahead.token == Token.RPAREN) {
                break;
            } else {
                throw new RuntimeException("Syntax error");
            }
        }
        return params;
    }

    public Param parserParam() throws IOException {
        Type type = parserType();
        Symbol symbol = match(Token.IDENTIFIER);
        return new Param(type, symbol);
    }

    public Type parserType() throws IOException {
        Symbol symbol;
        try {
            symbol = match(Token.INT);
        }catch (RuntimeException e) {
            symbol = match(Token.FLOAT);
        }
        return new Type(symbol);
    }

    public Expression parserExpression() throws IOException {
        Symbol identifier = match(Token.IDENTIFIER);
        Symbol operator;
        if (lookahead.token != Token.SEMICOLON) {
            if (lookahead.token == Token.ADD) {
                operator = match(Token.ADD);
            } else if (lookahead.token == Token.Minus) {
                operator = match(Token.Minus);
            } else {
                throw new RuntimeException("Syntax error");
            }
            return new Expression(identifier, operator, parserExpression());
        } else {
            return new Expression(identifier, null, null);
        }

    }

    public ReturnStatement parserReturnStatement() throws IOException {
        match(Token.RETURN);
        Expression expression = parserExpression();
        match(Token.SEMICOLON);
        return new ReturnStatement(expression);
    }

    public Function parserFunction() throws IOException {
        Type returnType;
        if(lookahead.token == Token.INT){
            returnType = new Type(match(Token.INT));
        } else if (lookahead.token == Token.FLOAT) {
            returnType = new Type(match(Token.FLOAT));
        } else {
            throw new RuntimeException("Syntax error");
        }
        Symbol identifier = match(Token.IDENTIFIER);
        match(Token.LPAREN);

        List<Param> params = parserParamList();

        match(Token.RPAREN);
        match(Token.LBRACE);
        ReturnStatement returnStatement = parserReturnStatement();
        Body body = new Body(returnStatement);
        match(Token.RBRACE);
        return new Function(identifier, returnType, params, body);
    }

}
