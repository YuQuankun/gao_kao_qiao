package soft.service.Impl;

import org.springframework.stereotype.Service;
import soft.common.ApiResponse;
import soft.constant.ErrorCode;
import soft.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import soft.pojo.model.UserInfo;
import soft.service.IUserInfoService;
import soft.util.ResponseUtil;

import java.util.List;

/**
 * @author kun_mi
 */
@Service
public class UserInfoImpl  implements IUserInfoService, ErrorCode {

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
