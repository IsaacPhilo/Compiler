import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {
    protected List<ASTNode> children;
    protected ASTNode(){
        children = new ArrayList<>();
    }
    abstract String getRegex();
    abstract String getContent();
    List<ASTNode> getChildren(){
        return children;
    };
    abstract boolean isOperator();
}
/*
(we're guaranteeing for now that the previous token parse passed
all relevant characters from the previous relevant token)

--token types--
integer literal: "\d+"
plus: "\+"
minus: "\-" maybe
endline: ";" maybe
identifier: "[a-zA-Z][a-zA-Z\d]*" there's got to be a simpler way to specify capitalized/uncapitalized alphanumeric inclusion
space: trim this

Whitespace always ends a token
The moment when no regexes match
is the moment when you go back one character

--Precedence--

 */