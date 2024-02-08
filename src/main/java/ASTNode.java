import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {
    protected String content;
    protected ASTNode(String inputContent){content = inputContent;}

    //necessary instance methods
    /**
     * This method is an instance method to comply with the fact that some ASTNodes will have content that depends on the particular instance, whereas symbols will always have the same value.
     * @return This method should return the content of the node--whether that be the value of a particular int, or the symbol of an operator
     */
    public String getContent(){return content;};

    //default static methods
    public static String getRegex(){return "";};
    public static boolean isOperator(){return false;};
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