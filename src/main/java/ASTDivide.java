import java.util.List;

public class ASTDivide extends Nonterminal{
    public ASTDivide(ASTNode... childNodes){
        super("/", childNodes);
    }

    //Hidden static methods of the superclass
    public static String getRegex() {
        return "\\/";
    }
    public static boolean isOperator() {
        return true;
    }
}
