package soft.service;


import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.UserInfo;
import soft.pojo.param.UserInfoParam;

import java.util.List;

/**
 * @author kun_mi
 */

public interface IUserInfoService extends IService<UserInfo>{

    /**
     * 根据Code获取用户OpenId
     * @param code
     * @return
     */
    ApiResponse<String> getOpenId(String code);

    /**
     * 保存用户个人信息
     * @param userInfoParam
     * @return
     */
    ApiResponse<Boolean> saveInfo(UserInfoParam userInfoParam);

    /**
     * 根据OpenId获取用户个人信息
     * @param openId
     * @return
     */
    ApiResponse<UserInfo> getInfo(String openId);


}
