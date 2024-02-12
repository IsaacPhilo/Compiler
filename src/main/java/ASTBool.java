public class ASTBool extends ASTNode{
    public static final String regularExpression = "(true|false)";
    private boolean type;

    public ASTBool(String inputContent) {
        super(inputContent);
        type = inputContent.equals("true");//add functionality at some point for crafting a boolean with things other than the literal strings "true" and "false"
    }

    public boolean getValue(){
        return type;
    }

    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator(){
        return false;
    }
}