# ToyParser

ToyParser includes a simple Lexer and a simple Parser.
It is used to help us understand how to write a Lexer and a Parser.

## simple Lexer and Parser

It is a very simple Lexer and Parser. The only valid token is 'a' and 'b' and 'END'.
The only valid grammar is : S -> a b a

People can use it to learn the basic idea of Lexer and Parser.

## complex Lexer and Parser

It is a very simple Lexer and Parser actually, even though it is called complex.
It is a good example to show how to write a more complex Lexer and Parser. We can modify it 
to fit to a more complex language.

The following is the description of the language:

The only valid tokens are:

* keyword: return
* special token: ; | ( | ) | { | } | ,
* identifier: f | a | b;
* type: int | float
* operator: + | -


As in this project, we are only interested in the Parser, so we assume that the Lexer will
always have no error.

The only valid grammar is:

    S -> T ID ( P ) { B }
    T -> int | float
    P -> T ID | T ID , P
    B -> return E ;
    E -> ID | ID + E | ID - E
    ID -> f | a | b

The following is a valid program:
    
1. valid program 1:
    ```
    int f(int a, float b) {
        return a + b - a;
    }
    ```
2. valid program 2:
 
    ```
    int f(int a, int b) {
        return b - a;
    }
    ```

The following is an invalid program:
    ```
    int f(int a, float b {  // missing )
        return a + b - a;
    }
    ```

## Note

This is a very easy parser and lexer, so we only use it as an example, so please
do not say, "Hey, you lexer and parser are not correct, you should do this and that. You don't
consider this and that."

Ofc, you can say that the lexer and parser have some bugs, but please do not say that we need to 
implement more further features.

## Reference

This is a note for course ["Language and translator"](https://uclouvain.be/en-cours-2021-linfo2132) in UCLouvain.
