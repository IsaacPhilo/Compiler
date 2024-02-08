public class ASTIdentifier extends ASTNode{
    public static final String regularExpression = "[a-zA-Z][a-zA-Z0-9]*";//This will match all alphabetic keywords; since this is the case, client tokenizer code will need to ignore this class as an option when considering which node type to create when the analyzed string, having whitespace on the right and (whitespace or token boundaries) on the left, matches an alphabetic keyword
    private String type;
    public ASTIdentifier(String variableType, String name) {
        super(name);
        type = variableType;
    }
    public String getType(){return type;}

    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator() {
        return false;
    }
}
