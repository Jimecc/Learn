package Exception;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月12日
 */
public class ExtendsException extends Exception{

    public ExtendsException() {
        super();
    }

    public ExtendsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExtendsException(String message) {
        super(message);
    }
}
