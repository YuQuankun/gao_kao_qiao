package controller;

import common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pojo.model.UserInfo;
import service.IUserInfoService;
import util.ResponseUtil;
import java.util.List;

/**
 * @author kun_mi
 */

@RestController

public class LogInController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    public ApiResponse<List<UserInfo>> getInfo(){
        return iUserInfoService.getInfo();
    }
}