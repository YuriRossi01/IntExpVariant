grammar IntExp;

main :  prog EOF ;
prog :  init exp ;

init : (ID EQUAL exp TERM )* ;

exp  : FLOAT                            # num
     | ID                               # id
     | <assoc = right> exp POW exp      # pow
     | exp op=(MUL | DIV | MOD) exp     # mulDivMod
     | exp op=(PLUS | SUB) exp          # plusSub
     | LPAR exp RPAR                    # par
;
LPAR : '(' ;
RPAR : ')' ;
PLUS : '+' ;
MUL  : '*' ;
SUB  : '-' ;
DIV  : '/' ;
POW  : '^' ;
MOD  : 'mod' ;
TERM : ';' ;
EQUAL : '=' ;


FLOAT : INT | (INT | '-' '0' ) '.' DIGIT + ;
fragment INT : NAT | '-' POS    ;
fragment NAT : '0' | POS        ;
fragment POS : POSDIGIT DIGIT * ;
fragment DIGIT : '0' | POSDIGIT ;
fragment POSDIGIT : [1-9]       ;

ID : [a-z]+ ;
WS   : [ \t\n\r]+ -> skip ;

