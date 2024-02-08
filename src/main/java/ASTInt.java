import java.util.ArrayList;
import java.util.List;

public class ASTInt extends ASTNode implements NumberType<Integer>{
    public ASTInt(String input){
        super(input);
    }

    public Integer getValue(){return Integer.parseInt(content);}

    //Hidden static methods of the superclass
    public static String getRegex() {
        return "\\d+";
    }
    public static boolean isOperator(){
        return false;
    }
}
