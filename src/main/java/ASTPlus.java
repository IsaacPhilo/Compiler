import java.util.ArrayList;
import java.util.List;

public class ASTPlus extends Nonterminal{
    public ASTPlus(ASTNode... childNodes){
        super("+", childNodes);
    }

    //Hidden static methods of the superclass
    public static String getRegex() {
        return "\\+";
    }
    public static boolean isOperator() {
        return true;
    }
}
