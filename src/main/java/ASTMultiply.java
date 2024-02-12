public class ASTMultiply extends Nonterminal{
    public static final String regularExpression = "\\*";
    public ASTMultiply(ASTNode... childNodes) {
        super("*", childNodes);
    }
    public ASTMultiply(String input){super(input);}
    public ASTMultiply(){this("-");}
    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator() {
        return true;
    }
}
