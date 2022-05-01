package soft.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import soft.common.ApiResponse;
import soft.constant.ErrorCode;
import soft.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import soft.pojo.model.UserInfo;
import soft.service.IUserInfoService;
import soft.util.HttpRequestUtil;
import soft.util.ResponseUtil;

import java.util.List;

/**
 * @author kun_mi
 */
@Service
public class UserInfoImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements IUserInfoService, ErrorCode  {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private HttpRequestUtil httpRequestUtil;

    @Value("${app.appId}")
    private String appId;

    @Value("${app.secret}")
    private String appSecret;

    private String code;

    @Override
    public ApiResponse<String> getOpenId(String code) {
        return ResponseUtil.success(httpRequestUtil.getOpenId(appId,appSecret,code));
    }

    @Override
    public ApiResponse<List<UserInfo>> getInfo() {
        return ResponseUtil.success(userInfoMapper.selectInfo());
    }

    @Override
    public ApiResponse<Boolean> saveInfo(){
        return ResponseUtil.success();
    }
}
