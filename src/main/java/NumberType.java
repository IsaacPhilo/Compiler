/**
 * An interface for allowing RTTI to
 * classify which nodes are numbers
 * without requiring my numeric nodes
 * to fall under the Number class hierarchy
 * @param <T> The numeric literal type
 */
public interface NumberType<T extends Number>{
    public T getValue();
}
