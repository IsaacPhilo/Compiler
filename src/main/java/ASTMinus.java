public class ASTMinus extends Nonterminal{
    public <T extends ASTNode & NumberType<?>> ASTMinus(T... childNodes){
        super("-", childNodes);
    }

    //Overridden static methods from superclass
    public static String getRegex() {
        return "\\-";
    }
    public static boolean isOperator(){return true;}
}
