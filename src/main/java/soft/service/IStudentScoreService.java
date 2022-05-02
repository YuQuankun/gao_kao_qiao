package soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.StudentScore;
import soft.pojo.param.StudentScoreParam;

/**
 * @author kun_mi
 */
public interface IStudentScoreService extends IService<StudentScore> {

    /**
     * 保存学生分数信息
     * @param studentScoreParam
     * @return
     */
    ApiResponse<Boolean> saveScore(StudentScoreParam studentScoreParam);
}
