package common;


import constant.ResponseConstant;
import execption.BaseException;
import handler.MessageSourceHandler;
import lombok.Data;

/**
 * @author kun_mi
 */
@Data
public class ApiResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public ApiResponse() {

    }

    public ApiResponse(Integer code) {
        MessageSourceHandler messageSourceHandler = new MessageSourceHandler();
        this.code = code;
        this.message = messageSourceHandler.getMessage(String.valueOf(code));
    }

    public ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(Integer code, T data) {
        MessageSourceHandler messageSourceHandler = new MessageSourceHandler();

        this.code = code;
        this.data = data;
        this.message = messageSourceHandler.getMessage(String.valueOf(code));
    }

    public ApiResponse(ResponseConstant responseConstant) {
        this.code = responseConstant.getCode();
        this.message = responseConstant.getMessage();
    }

    public ApiResponse(BaseException exception) {
        this.code = exception.getCode();
        this.message = exception.getMessage();
    }
}