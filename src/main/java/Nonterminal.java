import java.util.ArrayList;
import java.util.List;

public abstract class Nonterminal extends ASTNode{//A class for nodes which should be able to have children
    protected List<ASTNode> children;
    protected Nonterminal(String inputContent, ASTNode... childNodes){
        super(inputContent);

        //All Nonterminal nodes should be able to hold children
        children = new ArrayList<>();
        for(ASTNode n: childNodes){
            addChild(n);
        }
    }

    //Nonterminal-node-specific functions:
    /**
     *
     * @param child the ASTNode to add as a child
     * @return the index in the List of children to which the node has been added, for future reference order
     */
    public int addChild(ASTNode child){
        children.add(child);
        return children.indexOf(child);
    }

    /**
     * Every Nonterminal node should be able to have children
     * @return the list of children
     */
    public List<ASTNode> getChildren(){
        return children;
    }
}
