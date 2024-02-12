public class ASTIdentifier extends ASTNode{
    //all alphabetic keywords will be negatively matched in the below regular expression
    public static final String regularExpression = "(?!(int)|(true)|(false))[a-zA-Z][a-zA-Z0-9]*";//This will match all alphabetic keywords; since this is the case, client tokenizer code will need to ignore this class as an option when considering which node type to create when the analyzed string, having whitespace on the right and (whitespace or token boundaries) on the left, matches an alphabetic keyword
    private String type;
    public ASTIdentifier(String input) {//we can pass the arguments necessary to specify a variable in a single string
        super(input.split(" ")[0]);//passing the name to the superclass
        if(!(input.split(" ").length < 2)){//if no second argument was passed
            type = input.split(" ")[1];
        }
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
