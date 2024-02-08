public class ASTMinus extends Nonterminal{
    public ASTMinus(NumberType... childNodes){
        super("-", (ASTNode[])childNodes);
    }

    //Overridden static methods from superclass
    public static String getRegex() {
        return "\\-";
    }
    public static boolean isOperator(){return true;}
}
