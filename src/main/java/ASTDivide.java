import java.util.List;

public class ASTDivide extends ASTNode{

    @Override
    String getRegex() {
        return "\\/";
    }

    @Override
    String getContent() {
        return "/";
    }

    @Override
    boolean isOperator() {
        return true;
    }
}
