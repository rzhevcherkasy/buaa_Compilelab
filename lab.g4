grammar lab;


//Nonzerodigit:[1-9];
//Octaldigit:[1-7];
Hexadecimal_prefix:'0x' | '0X';

Decimal_const:[0-9]|[1-9][0-9]+;
Octal_const:'0'[0-7]*;
Hexadecimal_const:Hexadecimal_prefix[0-9a-zA-Z]+;
RET: ('\n' | '\r'|'\t'|' ') ->skip;
Condop1:'<' | '>' | '<=' | '>=';
Condop2:'==' | '!=';
CONTINUE:'continue';
BREAK:'break';


btype:'int';
functype:'int'|'void';
unaryop:'+' | '-'|'!';
compunit: (decl|funcDef)+;
number:Decimal_const | Octal_const | Hexadecimal_const;
funcDef:functype Ident  '('funcfparams? ')'   block;
funcfparams:funcfparam(',' funcfparam)*;
funcfparam:btype Ident ('[' ']' ('[' exp ']')*)?;



block:'{' blockItem+ '}';
blockItem:decl| stmt;
unaryexp:primaryexp|unaryop unaryexp| Ident '(' funcrparams ')';

stmt:'return' exp? ';'|exp?';'|lval'=' exp ';'|'if' '(' cond ')' stmt ('else' stmt)?|block| 'while' '(' cond ')' stmt|BREAK ';'| CONTINUE ';';

decl:constdecl | vardecl;
constdecl:'const' btype constdef (',' constdef)* ';';
constdef:Ident ('[' constexp ']')*'=' constinitval;
constinitval:constexp| '{' (constinitval (',' constinitval)*)? '}';
constexp:addexp;
vardecl:btype vardef (',' vardef)* ';';
vardef:Ident('[' constexp ']' )*| Ident('[' constexp ']' )* '=' initval;
initval:exp|'{' (initval (',' initval)*) ?'}';
exp:addexp;
addexp:mulexp (('+'|'-')mulexp)*;
mulexp:unaryexp (('*' | '/' | '%')unaryexp)*;
funcrparams:(exp(',' exp)*)|;
primaryexp:'('exp')'|number|lval ;
lval:Ident('['exp']')*;
//cond
cond:lorexp;
relexp:addexp(Condop1 addexp)* ; // [new]
eqexp:relexp(Condop2 relexp)* ;// [new]
landexp:eqexp('&&' eqexp)* ;// [new]
lorexp:landexp('||' landexp)*;// [new]

Ident:([a-zA-Z]|'_')(([a-zA-Z]|[0-9]|'_')*);














