%token INT FLOAT IDENTIFIER NUMBER
%token FUNC RETURN PRINT
%token SEMICOLON LPAREN RPAREN LBRACE RBRACE COMMA
%token PLUS MINUS MUL DIV ASSIGN

%start program

%%
program
	: function program
	| empty
	;


function:
	FUNC type IDENTIFIER LPAREN params RPAREN LBRACE block RBRACE
	;

params
	: param params_tail
	| empty
	;

param
	: type IDENTIFIER
	;

params_tail
	: COMMA param params_tail
	| empty
	;

block
	: statement block
	| empty
	;

statement
	: return_statement
	| function_call_statement
	| declaration_statement
	| assignment_statement
	;

assignment_statement
	: IDENTIFIER ASSIGN expression SEMICOLON
	;

return_statement
	: RETURN expression SEMICOLON
	;

function_call_statement
	: PRINT LPAREN expression RPAREN SEMICOLON
	| IDENTIFIER LPAREN argument_expression_list RPAREN SEMICOLON
	;

declaration_statement
	: declator SEMICOLON
	| declator ASSIGN expression SEMICOLON
	;

declator
	: type IDENTIFIER
	;


primary_expression
	: IDENTIFIER
	| INTEGER
	| FLOAT
	;

postfix_expression
	: primary_expression
	| postfix_expression LPAREN argument_expression_list RPAREN
	;

argument_expression_list
	: assignment_expression
	| argument_expression_list ',' assignment_expression
	| empty
	;

unary_expression
	: primary_expression
	| MINUS unary_expression
	;

multiplicative_expression
	: unary_expression
	| multiplicative_expression MUL unary_expression
	| multiplicative_expression DIV unary_expression
	;

additive_expression
	: multiplicative_expression
	| additive_expression PLUS multiplicative_expression
	| additive_expression MINUS multiplicative_expression
	;


expression
	: additive_expression
	;

empty
	:
	;

%%