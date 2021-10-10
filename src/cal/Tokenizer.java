package cal;

public class Tokenizer {

    private StringIter it;

    public Tokenizer(StringIter it) {
        this.it = it;
    }

    public boolean nextToken() throws Exception {
        it.readAll();
     //   System.out.println("meichaoguo");

        skipSpaceCharacters();
      //  System.out.println("chaoguol");
        if (it.isEOF()) {
            return false;
        }

        char peek = it.peekChar();
        if (Character.isDigit(peek)) {
           // System.out.println("lexUInt");
            lexUInt();
            return true;
        } else if (Character.isAlphabetic(peek)||peek=='_') {
           // System.out.println("lexIdentOrKeyword");
            lexIdentOrKeyword();
            return true;
        } else {
           //1if System.out.println("others");
            lexOperatorOrUnknown();
            return true;
        }
    }

    private void lexUInt() throws Exception  {

        Pos tempBegin = new Pos(it.currentPos().row, it.currentPos().col);
        String TemNum="";
        int tempNum = 0;
        while(Character.isDigit(it.peekChar())) {
            TemNum+=it.nextChar();
            //tempNum = tempNum * 10 + it.nextChar() - 48;
        }

       System.out.println("Number("+TemNum+")");
    }

    private void lexIdentOrKeyword() throws Exception {

        Pos tempBegin = new Pos(it.currentPos().row, it.currentPos().col);
        StringBuilder tempStringBuilder = new StringBuilder("");


        while(Character.isLetterOrDigit(it.peekChar())||it.peekChar()=='_') {
            tempStringBuilder.append(it.nextChar());
        }
        String tempString = tempStringBuilder.toString();
        switch(tempString) {
            case "if":
                System.out.println("If");
                break;
            case "else":
                System.out.println("Else");
                break;
            case "while":
                System.out.println("While");
                break;
            case "break":
                System.out.println("Break");
                break;
            case "continue":
                System.out.println("Continue");
                break;
            case "return":
                System.out.println("Return");
                break;
            default:
                System.out.println("Ident("+tempString+")");
        }

    }

    private void lexOperatorOrUnknown() throws Exception {
        switch (it.nextChar()) {
            case '+':
                System.out.println("Plus");
                break;

            case '*':
                System.out.println("Mult");
                break;

            case '/':
                System.out.println("Div");
                break;

            case '=':
                if(it.peekChar()=='='){
                    System.out.println("Eq");
                    char consume=it.nextChar();
                }
                else{
                    System.out.println("Assign");
                }
                break;

            case ';':
                System.out.println("Semicolon");
                break;

            case '(':
                System.out.println("LPar");
                break;

            case ')':
                System.out.println("RPar");
                break;

            case '{':
                System.out.println("LBrace");
                break;

            case '}':
                System.out.println("RBrace");
                break;

            case '<':
                System.out.println("Lt");
                break;

            case '>':
                System.out.println("Gt");
                break;

            default:
                System.out.println("Err");
                throw new Exception("Err");
        }
    }

    private void skipSpaceCharacters() {
        while (!it.isEOF() && Character.isWhitespace(it.peekChar())) {
            it.nextChar();
        }
    }
}