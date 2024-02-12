public class ASTByte extends ASTNode implements NumberType<Byte>{
    public static final String regularExpression = "(\\-?[1-128])|[[0-127])";//Tutorialspoint said that the smallest value a byte can take on is 127, but -128 seems more consistent with the other number data types
    private byte value;

    protected ASTByte(String inputContent) {
        super(inputContent);
        value = Byte.parseByte(inputContent);
    }

    //Hidden static methods of the superclass
    public static String getRegex() {
        return regularExpression;
    }
    public static boolean isOperator(){
        return false;
    }

    @Override
    public Byte getValue() {
        return value;
    }
}
