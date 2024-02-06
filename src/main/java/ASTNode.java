import java.util.List;
public interface ASTNode {
    String getOperator();
    List<ASTNode> getChildren();

}