import java.util.ArrayList;
import java.util.List;

public class ASTPlus extends Nonterminal{
    public static final String regularExpression = "\\+";
    public ASTPlus(ASTNode... childNodes){
        super("+", childNodes);
    }

    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator() {
        return true;
    }
}
