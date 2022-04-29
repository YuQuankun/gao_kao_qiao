package soft.constant;

/**
 * @author kun_mi
 */
public interface ErrorCode {
    int SUCCEED = 0;
    /**
     * 参数错误
     */
    int PARAMS_IS_NULL = 10001;
    int PARAMS_NOT_COMPLETE = 10002;
    int PARAMS_TYPE_ERROR = 10003;
    int PARAMS_IS_INVALID = 10004;

    /**
     * 用户错误
     */
    int USER_NOT_EXIST = 20001;
    int USER_NOT_LOGGED_IN = 20002;
    int USER_ACCOUNT_ERROR = 20003;
    int USER_ACCOUNT_FORBIDDEN = 20004;
    int USER_HAS_EXIST = 20005;
    int BAD_CREDENTIALS = 20006;

    /**
     * 请求错误
     */
    int NO_HANDLER_FOUND = 30001;
    int METHOD_NOT_SUPPORTED = 30002;
    int CONSTRAINT_VIOLATION = 30003;
    int METHOD_MISMATCH = 30004;
    int MESSAGE_NOT_READABLE = 30005;
    int BASE_ERROR = 30006;
    /**
     * 系统错误
     */
    int SYSTEM_INNER_ERROR = 40001;

    /**
     * 数据错误
     */
    int DATA_NOT_FOUND = 50001;
    int DATA_IS_WRONG = 50002;
    int DATA_IS_ASSOCIATED = 50003;
    int DATA_ALREADY_EXISTED = 50004;
    int DATA_INSERT_ERROR = 50005;
    int DATA_DELETE_ERROR = 50006;
    int DATA_UPDATE_ERROR = 50007;
    int DATA_IS_REVIEWING = 50008;
    /**
     * 接口错误
     */
    int INTERNAL_INTERFACE_EXCEPTION = 60001;
    int EXTERNAL_INTERFACE_EXCEPTION = 60002;
    int INTERFACE_FORBIDDEN = 60003;
    int INTERFACE_ADDRESS_INVALID = 60004;
    int INTERFACE_REQUEST_TIMEOUT = 60005;
    int INTERFACE_EXCEED_LOAD = 60006;
    /**
     * 权限错误
     */
    int PERMISSION_NO_ACCESS = 70001;
    /**
     * 飞书异常
     */
    int LARK_TOKEN_EXCEPTION = 80001;
    int LARK_USER_EXCEPTION = 80002;
    int LARK_NOTICE_EXCEPTION = 80003;
    /**
     * Excel解析异常
     */
    int EXCEL_ENUM_CONVERT_EXCEPTION = 90001;

    int UN_CATCH_ERROR = 99999;

}
