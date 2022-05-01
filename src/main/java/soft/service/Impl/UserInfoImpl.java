package soft.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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


    @Override
    public ApiResponse<String> getOpenId(String code) {
        return ResponseUtil.success(httpRequestUtil.getOpenId(appId,appSecret,code));
    }

    @Override
    public ApiResponse<UserInfo> getInfo(String openId) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",openId);
        return ResponseUtil.success(userInfoMapper.selectOne(wrapper));
    }

    @Override
    public ApiResponse<Boolean> saveInfo(){
        return ResponseUtil.success();
    }
}