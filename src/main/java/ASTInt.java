import java.util.ArrayList;
import java.util.List;

public class ASTInt extends ASTNode implements NumberType<Integer>{
    public static final String regularExpression = "(\\-[1-2147483648])|([0-2147483647])";
    public ASTInt(String input){
        super(input);
    }

    public Integer getValue(){return Integer.parseInt(content);}

    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator(){
        return false;
    }
}
