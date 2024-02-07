import java.util.ArrayList;
import java.util.List;

public class ASTInt extends ASTNode{
    private String content;

    public ASTInt(String input){
        super();
        content = input;
    }

    public int addChild(ASTNode child){//the int return value gives me the position of the added child within the array for future reference order
        children.add(child);
        return children.indexOf(child);
    }

    @Override
    public String getRegex() {
        return "\\d+";
    }

    @Override
    public String getContent(){
        return content;
    }
    
    @Override
    public boolean isOperator(){
        return false;
    }
}
