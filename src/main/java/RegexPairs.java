import java.util.ArrayList;
import java.util.List;

public class RegexPairs {
    public static final String[] regexes = {"(true|false)", "0b((\\-?[1-128])|([0-127]))", "\'[ -~]\'", "\\/",  "(?!(int)|(true)|(false))[a-zA-Z][a-zA-Z0-9]*", "(\\-[1-2147483648])|([0-2147483647])", "(\\[1-9223372036854775808])|([0-9223372036854775807])L", "\\-", "\\*", "\\+"};
    public static final String[] names = {"bool", "byte", "char", "divide", "identifier", "int", "long", "minus", "multiply", "plus"};

    public static List<String> matchedNames(String toMatch){
        ArrayList<String> matched = new ArrayList<>();
        for(int i = 0; i < regexes.length; i++){
            if(toMatch.matches(regexes[i])){
                matched.add(names[i]);
            }
        }
        return matched;
    }

    public static List<String> matchedRegexes(String toMatch){
        ArrayList<String> matched = new ArrayList<>();
        for(int i = 0; i < regexes.length; i++){
            if(toMatch.matches(regexes[i])){
                matched.add(regexes[i]);
            }
        }
        return matched;
    }

    public int numMatched(String toMatch){
        return matchedNames(toMatch).size();
    }
}
