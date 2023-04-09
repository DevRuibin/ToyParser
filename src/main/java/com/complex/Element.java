package com.complex;

import java.util.List;

abstract class Element {
}

class Type extends Element {
    Symbol attribute;
    public Type(Symbol attribute) {
        this.attribute = attribute;
    }
}

class Param{
    Type type;
    Symbol name;
    public Param(Type type, Symbol name) {
        this.name = name;
        this.type = type;
    }
}

class Function extends Element {
    Symbol name;
    List<Param> params;
    Type returnType;

    Body body;
    public Function(Symbol name, Type returnType, List<Param> params, Body body) {
        this.name = name;
        this.params = params;
        this.returnType = returnType;
    }
}

class Body extends Element {
    ReturnStatement returnStatement;
    public Body(ReturnStatement returnStatement) {
        this.returnStatement = returnStatement;
    }
}


class Expression extends Element {
    Symbol identifier;
    Symbol operator;
    Expression right;

    public Expression(Symbol identifier, Symbol operator, Expression right) {
        this.identifier = identifier;
        this.operator = operator;
        this.right = right;
    }
}
class ReturnStatement extends Element {
    Expression expression;
    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }
}


