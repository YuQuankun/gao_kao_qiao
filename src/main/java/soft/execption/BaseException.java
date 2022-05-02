package soft.execption;



import soft.constant.ErrorCode;
import soft.handler.MessageSourceHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author kun_mi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends Exception implements ErrorCode {

    private final Integer code;

    private final String message;

    public BaseException(Integer code) {
        MessageSourceHandler messageSourceHandler = new MessageSourceHandler();

        this.code = code;
        this.message = messageSourceHandler.getMessage(String.valueOf(code));
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
