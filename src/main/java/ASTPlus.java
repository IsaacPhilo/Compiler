import java.util.ArrayList;
import java.util.List;

public class ASTPlus extends ASTNode{
    public ASTPlus(ASTInt int1, ASTInt int2){
        super();
        children.add(int1);
        children.add(int2);
    }

    public ASTPlus(ASTInt int1){
        super();
        children.add(int1);
    }

    @Override
    String getRegex() {
        return "\\+";
    }

    @Override
    String getContent() {
        return "+";
    }

    @Override
    boolean isOperator() {
        return true;
    }
}
