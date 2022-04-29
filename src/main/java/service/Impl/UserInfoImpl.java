package service.Impl;

import common.ApiResponse;
import constant.ErrorCode;
import mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pojo.model.UserInfo;
import service.IUserInfoService;
import util.ResponseUtil;

import java.util.List;

/**
 * @author kun_mi
 */
public class UserInfoImpl  extends ServiceImpl<UserInfoMapper,UserInfo> implements IUserInfoService, ErrorCode {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ApiResponse<List<UserInfo>> getInfo() {
        return ResponseUtil.success(userInfoMapper.selectInfo());
    }

    @Override
    public ApiResponse<Boolean> saveInfo(){
        return ResponseUtil.success();
    }
}
