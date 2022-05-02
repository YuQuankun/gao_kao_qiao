package soft.constant;

import lombok.Getter;

/**
 * @author kun_mi
 */

@Getter
public enum ResponseConstant {
    SUCCEED(0, "ok"),

    // --------参数错误--------
    // 参数为空
    PARAMS_IS_NULL(10001, "params is null"),
    // 参数不全
    PARAMS_NOT_COMPLETE(10002, "params not complete"),
    // 参数类型错误
    PARAMS_TYPE_ERROR(10003, "params type error"),
    // 参数无效
    PARAMS_IS_INVALID(10004, "params is invalid"),

    // --------用户错误--------
    // 用户不存在
    USER_NOT_EXIST(20001, "user not exist"),
    // 用户未登陆
    USER_NOT_LOGGED_IN(20002, "user not logged in"),
    // 用户未登陆
    USER_ACCOUNT_ERROR(20003, "user account error"),
    // 用户账户已被禁用
    USER_ACCOUNT_FORBIDDEN(20004, "user account forbidden"),
    // 用户已存在
    USER_HAS_EXIST(20005, "user has exist"),

    // --------业务错误--------
    // 系统业务出现问题
    BUSINESS_ERROR(30001, "business error"),

    // --------系统错误--------
    // 系统内部错误
    SYSTEM_INNER_ERROR(40001, "system inner error"),

    // --------数据错误--------
    // 数据未找到
    DATA_NOT_FOUND(50001, "data not found"),
    // 数据有误
    DATA_IS_WRONG(50002, "data is wrong"),
    // 数据已存在
    DATA_ALREADY_EXISTED(50003, "data already existed"),
    // 数据添加失败
    DATA_INSERT_ERR(50004, "data insert error"),
    // 数据删除失败
    DATA_DELETE_ERR(50005, "data delete error"),
    // 数据修改失败
    DATA_UPDATE_ERR(50006, "date update error"),

    // --------接口错误--------
    // 系统内部接口调用异常
    INTERFACE_INNER_INVOKE_ERROR(60001, "interface inner invoke error"),
    // 系统外部接口调用异常
    INTERFACE_OUTER_INVOKE_ERROR(60002, "interface outer invoke error"),
    // 接口禁止访问
    INTERFACE_FORBIDDEN(60003, "interface forbidden"),
    // 接口地址无效
    INTERFACE_ADDRESS_INVALID(60004, "interface address invalid"),
    // 接口请求超时
    INTERFACE_REQUEST_TIMEOUT(60005, "interface request timeout"),
    // 接口负载过高
    INTERFACE_EXCEED_LOAD(60006, "interface exceed load"),

    // --------权限错误--------
    // 没有访问权限
    PERMISSION_NO_ACCESS(70001, "permission no access"),

    // 测试项异常
    ILLEGAL_PARAMS(71001, "illegal params"),

    // 未捕获通用异常
    ERROR(99999, "error");

    private final Integer code;

    private final String message;

    ResponseConstant(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
