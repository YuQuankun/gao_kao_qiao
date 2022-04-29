package soft.util;


import soft.common.ApiResponse;
import soft.constant.ErrorCode;
import soft.constant.ResponseConstant;
import org.springframework.stereotype.Component;

/**
 * @author: YangGang
 * @date: 2021/6/1 9:30 上午
 * @description: 全局通用返回工具类
 */
@Component
public class ResponseUtil implements ErrorCode {

    private ResponseUtil() {
    }


    /**
     * 请求成功返回
     *
     * @param object 返回数据
     * @return 全局通用返回体
     */
    public static <T> ApiResponse<T> success(T object) {
        ApiResponse<T> apiResponse = new ApiResponse<>(SUCCEED);
        apiResponse.setData(object);
        return apiResponse;
    }

    /**
     * 请求成功返回（无业务数据返回）
     */
    public static <T> ApiResponse<T> success() {
        return success(null);
    }

    public static <T> ApiResponse<T> error() {
        return error(ResponseConstant.ERROR, null);
    }

    public static <T> ApiResponse<T> error(ResponseConstant errorResult) {
        return new ApiResponse<>(errorResult);
    }

    public static <T> ApiResponse<T> error(Integer errorCode) {
        return new ApiResponse<>(errorCode, null);
    }

    public static <T> ApiResponse<T> error(Integer errorCode, String message) {
        return new ApiResponse<>(errorCode, message, null);
    }

    public static <T> ApiResponse<T> error(Integer errorCode, T object) {
        return new ApiResponse<>(errorCode, object);
    }

    public static <T> ApiResponse<T> error(ResponseConstant errorResult, T object) {
        ApiResponse<T> apiResponse = new ApiResponse<>(errorResult);
        apiResponse.setData(object);
        return apiResponse;
    }

}
