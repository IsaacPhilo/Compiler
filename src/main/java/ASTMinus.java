public class ASTMinus extends Nonterminal{
    public static final String regularExpression = "\\-";
    public ASTMinus(String input, ASTNode... childNodes){
        super("-", childNodes);
    }
    public ASTMinus(String input){super("-");}
    public ASTMinus(){this("-");}

    //Overridden static methods from superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator(){return true;}
}
