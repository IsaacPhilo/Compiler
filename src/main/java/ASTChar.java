public class ASTChar extends ASTNode{
    public static final String regularExpression = "\'[ -~]\'";//matches any Ascii character literal in single quotes

    protected ASTChar(String inputContent) {
        super(inputContent);
    }

    public char getChar(){
        return content.charAt(0);
    }

    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator(){
        return false;
    }
}
