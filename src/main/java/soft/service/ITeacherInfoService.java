package soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.TeacherInfo;
import soft.pojo.param.TeacherInfoParam;

/**
 * @author kun_mi
 */
public interface ITeacherInfoService extends IService<TeacherInfo> {

    /**
     * 保存教师信息
     * @param teacherInfoParam
     * @return
     */
    ApiResponse<Boolean> saveTeacherInfo(TeacherInfoParam teacherInfoParam);

}
