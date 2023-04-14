package user.exception;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LZN
 * Date: 2023-04-07
 * Time: 23:26
 */
public class uNameException extends RuntimeException{
    public uNameException() {
        super();
    }

    /**
     * Constructs an {@code ArithmeticException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public uNameException(String s) {
        super(s);
    }
}
