/**
 * This is an example for a more complex Parser and Lexer for a simple language.
 * It is very simple actually, but it is a good example for a more complex language.
 * In this language, we only consider the following tokens:
 * keyword: return
 * special token: ; | ( | ) | { | } | ,
 * identifier: f | a | b;
 * type: int | float
 * operator: + | -
 * <br>
 * for more convenience, we also assume that the lexer will never have any error.
 * Which means that the input program is always valid for lexical analysis.
 * <br>
 * The grammar is:
 * <pre>
 *     S -> T ID ( P ) { B }
 *     T -> int | float
 *     P -> T ID | T ID , P
 *     B -> return E ;
 *     E -> ID | ID + E | ID - E
 *     ID -> f | a | b
 * </pre>
 * <br>
 * The following is a valid program:
 * <pre>
 *     int f(int a, float b) {
 *          return a + b - a;
 *     }
 *     int f(int a, int b) {
 *          return b - a;
 *     }
 * </pre>
 * <br>
 * The following is an invalid program:
 * <pre>
 *     int f(int a, float b {  // missing )
 *          return a + b - a;
 *     }
 * </pre>
 * <strong>Note: This is a very easy parser and lexer, so we only use it as an example, so please
 * do not say, "Hey, you lexer and parser are not correct, you should do this and that. You don't
 * consider this and that."
 * </strong>
 * */

package com.complex;
