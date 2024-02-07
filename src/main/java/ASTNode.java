import java.util.List;
public interface ASTNode {
    String getOperator();
    List<ASTNode> getChildren();
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