public class ASTDivide extends Nonterminal{
    public static final String regularExpression = "\\/";
    public ASTDivide(String input, ASTNode... childNodes){
        super("/", childNodes);
    }
    public ASTDivide(String input){super(input);}
    public ASTDivide(){this("-");}
    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator() {
        return true;
    }
}
