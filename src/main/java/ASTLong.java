public class ASTLong extends ASTNode implements NumberType<Long>{
    public static final String regularExpression = "(\\-[1-9223372036854775808])|([0-9223372036854775807])L";
    long value;

    protected ASTLong(String inputContent) {
        super(inputContent);
        value = Long.parseLong(inputContent);
    }

    @Override
    public Long getValue() {
        return value;
    }

    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator(){
        return false;
    }
}
