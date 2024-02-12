import java.util.ArrayList;
import java.util.List;

public class ASTPlus extends Nonterminal{
    public static final String regularExpression = "\\+";
    public ASTPlus(String input, ASTNode... childNodes){
        super("+", childNodes);
    }
    public ASTPlus(String input){
        super("+");
    }
    public ASTPlus(){
        this("+");
    }
    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator() {
        return true;
    }
}
