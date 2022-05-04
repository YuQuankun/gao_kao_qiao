package soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.StudentSchool;
import soft.pojo.param.StudentSchoolParam;
import soft.pojo.param.StudentScoreParam;

import java.util.List;

/**
 * @author kun_mi
 */
public interface IStudentSchoolService extends IService<StudentSchool> {

    /**
     * 报错学生意向学校信息
     * @param studentSchoolParam
     * @return
     */
    public ApiResponse<Boolean> save(StudentSchoolParam studentSchoolParam);

    /**
     * 根据学生uuid获取意向学校信息
     * @param studentUuid
     * @return
     */
    public ApiResponse<List<StudentSchool>> get(Long studentUuid);
}