public class ASTMinus extends Nonterminal{
    public static final String regularExpression = "\\-";
    public <T extends ASTNode & NumberType<?>> ASTMinus(T... childNodes){
        super("-", childNodes);
    }

    //Overridden static methods from superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator(){return true;}
}
