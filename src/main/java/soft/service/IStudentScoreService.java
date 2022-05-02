package soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import soft.common.ApiResponse;
import soft.pojo.model.StudentScore;
import soft.pojo.param.StudentScoreParam;

import java.util.List;

/**
 * @author kun_mi
 */
public interface IStudentScoreService extends IService<StudentScore> {

    /**
     * 根据学生uuid获取该生历次考试成绩
     * @param uuid
     * @return
     */
    ApiResponse<List<StudentScore>> getScore(Long uuid);

    /**
     * 保存学生分数信息
     * @param studentScoreParam
     * @return
     */
    ApiResponse<Boolean> saveScore(StudentScoreParam studentScoreParam);
}
