grammar compile;


Number             : Decimal_const | Octal_const | Hexadecimal_const;
//Decimal_const      : Nonzero_digit | Decimal_const Digit;
Decimal_const      : Nonzero_digit (Digit)*;
Octal_const        : '0' (Octal_digit)*;
Hexadecimal_const  : Hexadecimal_prefix Hexadecimal_digit (Hexadecimal_digit)*;

Hexadecimal_prefix : '0x' | '0X';
Nonzero_digit      : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
Octal_digit        : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7';
Digit              : '0' | Nonzero_digit;
Hexadecimal_digit  : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
                      | 'a' | 'b' | 'c' | 'd' | 'e' | 'f'
                      | 'A' | 'B' | 'C' | 'D' | 'E' | 'F';
LPAREN: '(';
RPAREN: ')';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
INT:'int';
MAIN:'main';
Lbrace:'{';
Rbrace:'}';
RET:'return';
Checkpoint:';';
WHITE_SPACE: [ \r\n\t] -> skip; // -> skip 表示解析时跳过该规则


compUnit : funcDef;
funcDef  : funcType ident LPAREN RPAREN block;
funcType : INT;
ident    : MAIN;
block    : Lbrace stmt Rbrace;
stmt     : RET Number Checkpoint;
