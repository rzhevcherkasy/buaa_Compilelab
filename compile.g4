grammar compile;


//Nonzerodigit:[1-9];
//Octaldigit:[1-7];
Hexadecimal_prefix:'0x' | '0X';

Decimal_const:[0-9]|[1-9][0-9]+;
Octal_const:'0'[0-7]*;
Hexadecimal_const:Hexadecimal_prefix[0-9a-zA-Z]+;
RET: ('\n' | '\r'|'\t'|' ') ->skip;
Condop1:'<' | '>' | '<=' | '>=';
Condop2:'==' | '!=';



bType:'int';
funcType:'int';
unaryOp:'+' | '-' | '!';
compUnit: funcDef;
number:Decimal_const | Octal_const | Hexadecimal_const;
funcDef:funcType Ident  '(' ')'   block;
block:'{' blockItem+ '}';
blockItem:decl| stmt;
unaryExp:primaryExp|unaryOp unaryExp| Ident '(' funcrparams ')';

stmt:'return' exp ';'|exp';'|lval'=' exp ';'|'if' '(' cond ')' stmt ('else' stmt)?|block;
decl:constDecl | varDecl;
constDecl:'const' bType constDef (',' constDef)* ';';
constDef:Ident '=' constInitval;
constInitval:constExp;
constExp:addExp;
varDecl:bType varDef (',' varDef)* ';';
varDef:Ident | Ident '=' initval;
initval:exp;
exp:addExp;
addExp : mulExp | addExp ('+' | '-') mulExp;
mulExp :unaryExp | mulExp ('*' | '/' | '%') unaryExp;
//:mulExp (('+'|'-')mulExp)*;
//mulExp:unaryExp (('*' | '/' | '%')unaryExp)*;
funcrparams:(exp(',' exp)*)|;
primaryExp:'('exp')'|number|lval ;
lval:Ident;
//cond
cond:lorExp;
relExp:addExp(Condop1 addExp)* ; // [new]
eqExp:relExp(Condop2 relExp)* ;// [new]
landExp:eqExp('&&' eqExp)* ;// [new]
lorExp:landExp('||' landExp)*;// [new]

Ident:([a-zA-Z]|'_')(([a-zA-Z]|[0-9]|'_')*);














