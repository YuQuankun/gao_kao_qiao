package soft.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.annotaion.RequestPostSingleParam;
import soft.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import soft.pojo.model.UserInfo;
import soft.pojo.param.UserInfoParam;
import soft.service.IUserInfoService;
import java.util.List;

/**
 * @author kun_mi
 */

@Controller
@RequestMapping(value = "/user")
public class LogInController {

    @Autowired
    private IUserInfoService iUserInfoService;


    @Operation(description = "查询用户OpenId")
    @PostMapping(value = "/getOpenId")
    @ResponseBody
    public ApiResponse<String> getOpenId(@RequestPostSingleParam String code){
        return iUserInfoService.getOpenId(code);
    }

    @Operation(description = "保存用户个人信息")
    @PostMapping(value = "/saveUserInfo")
    @ResponseBody
    public ApiResponse<Boolean> saveUserInfo(@RequestBody @Validated UserInfoParam userInfoParam){
        return iUserInfoService.saveInfo(userInfoParam);
    }


    @Operation(description = "查询登陆用户账号密码等信息详情")
    @PostMapping(value = "/getInfo")
    @ResponseBody
    public ApiResponse<UserInfo> getInfo(@RequestPostSingleParam String openId){
        return iUserInfoService.getInfo(openId);
    }
}