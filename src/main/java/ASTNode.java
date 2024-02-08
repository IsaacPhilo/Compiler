import java.lang.reflect.InvocationTargetException;
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
    public static String getRegex(){return "";}

    /**
     * A version of this method that accepts a subclass type, and uses reflection to get the version of this method in the subclass
     * @param classType The Class object representing the particular subclass in question
     * @return The return value of the subclass's implementation of the getRegex() method without arguments
     */
    public static String getRegex(Class<? extends ASTNode> classType){
        if(!classType.equals(ASTNode.class)) {
            try {
                return (String)classType.getMethod("getRegex", null).invoke(null, null);
            } catch (Exception e) {
                System.out.println(e.toString());
                return "";
            }
        }
        else{
            return getRegex();
        }
    };

    public static boolean isOperator(){return false;};

    /**
     *A version of this method that accepts a subclass type, and uses reflection to get the version of this method in the subclass
     * @param classType The Class object representing the particular subclass in question
     * @return The return value of the subclass's implementation of the isOperator() method without arguments
     */
    public static boolean isOperator(Class<? extends ASTNode> classType){//A version of this method that accepts a subclass type, and uses reflection to get the version of this method in the subclass
        if(!classType.equals(ASTNode.class)) {
            try {
                return (Boolean)classType.getMethod("isOperator", null).invoke(null, null);
            } catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
        }
        else{
            return isOperator();
        }
    };
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