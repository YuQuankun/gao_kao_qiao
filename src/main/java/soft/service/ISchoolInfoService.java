package soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.SchoolInfo;
import soft.pojo.param.SchoolInfoParam;

/**
 * @author kun_mi
 */
public interface ISchoolInfoService extends IService<SchoolInfo> {

    /**
     * 保存学校信息
     * @param schoolInfoParam
     * @return
     */
    public ApiResponse<Boolean> save(SchoolInfoParam schoolInfoParam);

    /**
     * 获取学校相关信息
     * @param name
     * @return
     */
    public ApiResponse<SchoolInfo> get(String name);
}