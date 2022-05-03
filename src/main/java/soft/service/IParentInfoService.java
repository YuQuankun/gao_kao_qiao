package soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.ParentInfo;
import soft.pojo.param.ParentInfoParam;

/**
 * @author kun_mi
 */
public interface IParentInfoService extends IService<ParentInfo> {

    /**
     * 报错家长信息
     * @param param
     * @return
     */
    public ApiResponse<Boolean> save(ParentInfoParam param);

    /**
     * 根据uuid查询家长信息
     * @param uuid
     * @return
     */
    public ApiResponse<ParentInfo> get(Long uuid);
}
