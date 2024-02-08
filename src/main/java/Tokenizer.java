import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Tokenizer {//1 stack adds as many characters as it can to itself, 2nd stack pops from itself onto the put_back stack until itself contains a valid token, and then returns that token; then, the character at index 4 would be on the put_back stack beneath the character at index 3. The put_back stack is just to back.
    static Class[] NodeTypes;

    static {
        try {
            NodeTypes = new Class[] {Class.forName("ASTPlus"), Class.forName("ASTMinus"), Class.forName("ASTMultiply"), Class.forName("ASTDivide"), Class.forName("ASTInt")};
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Stack<Character> stack;
    Scanner sc;

    public Tokenizer(Scanner inputScanner){
        sc = inputScanner;
        sc.useDelimiter("");
    }

    char getCharacter(){//Will get a single character, either from the stack or from the scanner depending on whether the stack has content
        if(!stack.empty()){
            return stack.pop();
        }
        else{
            return sc.next().charAt(0);//this is assuming that the "useDelimiter("")" does result in one-character strings being returned
        }
    }

    void putBack(char c){//For when the scanner gone too far while scanning
        stack.push(c);
    }

    ASTNode getToken(){//will return the next token
        ASTNode node = null;
        String s = "";
        boolean tooFar = false;//tooFar will become true if we need to put characters onto the stack
        while(!tooFar){
            char c = getCharacter();

        }

        return node;
    }

    static List<Class> matchedClasses(String toMatch){
        ArrayList<Class> matched = new ArrayList<>();
        for(Class c: NodeTypes){
            try {
                if(toMatch.matches((String)(c.getField("regularExpression").get(null)))){
                    matched.add(c);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return matched;
    }
}
/*
Parse scanner char by char;
if we've gone too far, take characters
from (the stack that contains the most recently accessed character at the top),
and put these into another stack which contains
(the characters accessible in the scanner (original) order)
and use these characters the next time a token is scanned
(which is possible by examining whether the persistent stack contains characters.)

Token type is determined by regex-matching to predefined token regexes
The moment at which no regex matches is when we go back one or more characters

*/