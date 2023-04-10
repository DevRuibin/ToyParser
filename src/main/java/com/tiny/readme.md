# Tiny

This is the specification of the tiny language, called Tiny.

## Description

Tiny can be used to do some simple arithmetic operations, such as addition, subtraction, multiplication and division.
It is a single file language, which means that all the code is in one file.
It accepts a function define, variables define, function call, an assignment statement and a main function.
As in Tiny, we don't use void keyword, so the main function must return an integer. It should be like this:

```
func int main() {
    // do something
    return 0;
}
```

A function define is like this:

```
func int add(int a, int b) {
    return a + b;
}
```

A variable define is like this:

```
int a = 1;
```

A function call is like this:

```
int a = add(1, 2);
```

A valid program is like this:

```
func int add(int a, int b) {
    return a + b;
}

func int main() {
    int a = 1;
    int b = 2;
    int c = add(a, b);
    print(c);
    return 0;
}
```

## Token

The following is the list of tokens in Tiny:

* keyword: func
* keyword: return
* keyword: print
* special token: ; | ( | ) | { | } | , | =
* identifier: (\[a-zA-Z_\]\[a-zA-Z0-9_\]*)
* type: int | float
* operator: + | - | * | /
* number: (\[1-9]\[0-9\]* | 0)
* float: (\[1-9\]\[0-9\]*\.\[0-9\]+ | 0\.\[0-9\]+)
* whitespace: \s | \t | \n
* comment: //.*\n


Note:

1. The identifier, type and keyword are case-sensitive.
2. The number and float is decimal number.
3. The comment is single line comment.
4. The number is a 32-bit integer, and the float is a 32-bit float.
5. We don't support parentheses to change the priority of the operators.

## Grammar

You can find the grammar in the [file](grammar.y).

## Note

This looks like a very simple language, but it is not so easy to write a lexer and parser for it.
According to my schedule, I am afraid that I can't write a lexer and parser for it recently.
But I will try to do it in the future.

If you are interested in this language, you can try to write a lexer and parser for it. As I have
already written the DFA and the grammar, you can use them to implement your own lexer and parser.





