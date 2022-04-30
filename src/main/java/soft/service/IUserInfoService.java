package soft.service;


import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.UserInfo;

import java.util.List;

/**
 * @author kun_mi
 */

public interface IUserInfoService extends IService<UserInfo>{

    //
    /**
     * 获取用户信息
     * @return
     */
    ApiResponse<List<UserInfo>> getInfo();

    /***
     * 保存信息
     * @return
     */
    ApiResponse<Boolean> saveInfo();
}
