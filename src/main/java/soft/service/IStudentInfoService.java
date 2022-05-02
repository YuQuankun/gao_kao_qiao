package soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.StudentInfo;
import soft.pojo.param.StudentInfoParam;

/**
 * @author kun_mi
 */
public interface IStudentInfoService extends IService<StudentInfo> {

    /**
     * 保存学生基本信息
     * @param studentInfoParam
     * @return
     */
    ApiResponse<Boolean>  saveStudentInfo(StudentInfoParam studentInfoParam);


    /**
     * 根据ID查询学生详细信息
     * @param id
     * @return
     */
    ApiResponse<StudentInfo> getStudentInfo(Long id);
}
