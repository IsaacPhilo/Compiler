import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//TODO: Make sure you centralize the relevant regexes here instead of depending on dependencies of the node classes, and can have regexes that don't correspond to node types
public class Tokenizer {//1 stack adds as many characters as it can to itself, 2nd stack pops from itself onto the put_back stack until itself contains a valid token, and then returns that token; then, the character at index 4 would be on the put_back stack beneath the character at index 3. The put_back stack is just to back.
    static Class[] NodeTypes;
    static String[] regexes = {};
    boolean endofscanner;
    static boolean debug = false;
    static boolean debug2 = false;

    static {
        try {
            NodeTypes = new Class[] {Class.forName("ASTPlus"), Class.forName("ASTMinus"), Class.forName("ASTMultiply"), Class.forName("ASTDivide"), Class.forName("ASTInt"), Class.forName("ASTIdentifier"), Class.forName("ASTBool"), Class.forName("ASTChar")};//leaving out byte and long literals for now
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Stack<Character> stack;
    Scanner sc;

    public Tokenizer(Scanner inputScanner){
        sc = inputScanner;
        sc.useDelimiter("");
        stack = new Stack<>();
        endofscanner = false;
    }

    char getCharacter(){//Will get a single character, either from the stack or from the scanner depending on whether the stack has content
        if(!stack.empty()){
            return stack.pop();
        }
        else{
            if(sc.hasNext()){
                return sc.next().charAt(0);//this is assuming that the "useDelimiter("")" does result in one-character strings being returned
            }
            else{
                endofscanner = true;
                return '\0';
            }
        }
    }

    void putBack(char c){//For when the scanner gone too far while scanning
        stack.push(c);
    }

    //TODO: need to make a functionality for this which can tokenize into a series of tokens which are not necessarily nodes (since parentheses aren't nodes, for example)
//    ASTNode getTokenNode(){//will return the next token node
//        if(!sc.hasNext()){
//            if(debug){
//                System.out.println("Get token returning null due to end of scanner input...");
//            }
//            return null;
//        }
//
//        if(debug){
//            System.out.println("Get token running...");
//        }
//
//        ASTNode token = null;
//        String string = "";
//        boolean tooFar = false;//tooFar will become true if we need to put characters onto the stack
//        Stack<Character> localStack = new Stack<Character>();
//        List<Class> matched = null;
//
//        while(!tooFar){//go forward
//            char currentChar = getCharacter();//get the next character
//            localStack.push(currentChar);//store it in case it needs to be put back
//            string += currentChar;//string should hold the text of our token to create and return
//            if(debug){
//                System.out.println("Character received: " + currentChar);
//                System.out.println("\"String\" equals " + string);
//            }
//
//            if(("" + currentChar).matches("\\s")){//whitespace separates all adjacent tokens if present
//                if(string.matches("\\s+")){//if all we have is whitespace so far
//                    if(sc.hasNext()){//if this isn't at the end of the file
//                        string = "";
//                        localStack = new Stack<Character>();
//
//                        if(debug){
//                            System.out.println("Restarting tokenization from a leading space...");
//                        }
//                        continue;
//                    }
//                }
//                tooFar = true;//we don't need to put the space back on the stack since we're discarding it
//                break;
//            }
//
//            matched = matchedClasses(string);
//            if(debug){
//                System.out.println("Matched == " + matched);
//            }
//            if(matched.size()==0){//if no regexes are matched among any of the classes
//                tooFar = true;
//                putBack(localStack.pop());//although the currentCharacter is the only relevant thing to put back, it might be the case that we need to put back more than one, so I'm writing this more extensibly
//            }
//        }
//        //Now it should be the case that our string only corresponds to one node type
//        //For simplicity, I won't implement byte or long functionality right now
//        try {
//            string = string.substring(0, string.length()-1);
//            if(debug2){
//                System.out.println("Parsed string: " + string);
//            }
//            matched = matchedClasses(string);
//            if(debug2){
//                System.out.println("matched.size() == " + matched.size());
//            }
//            token = (ASTNode)matched.get(0).getConstructor(String.class).newInstance(string);
//            if(debug2){
//                System.out.println("token == " + token);
//            }
//            return token;
//        } catch (Exception e) {
//            System.out.println(e);
//            if(e instanceof InvocationTargetException){
//                System.out.println(((InvocationTargetException)e).getTargetException().toString());
//            }
//        }
//
//        if(debug){
//            System.out.println("Returning null at the end of the tokenizer...");
//        }
//        return null;
//    }

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