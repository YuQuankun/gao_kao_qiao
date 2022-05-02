package soft.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import soft.common.ApiResponse;
import soft.constant.ErrorCode;
import soft.mapper.StudentScoreMapper;
import soft.pojo.model.StudentScore;
import soft.pojo.param.StudentScoreParam;
import soft.service.IStudentScoreService;
import soft.util.ResponseUtil;

/**
 * @author kun_mi
 */
@Service
public class StudentScoreImpl extends ServiceImpl<StudentScoreMapper, StudentScore> implements IStudentScoreService, ErrorCode {

    private static final Logger LOG = LoggerFactory.getLogger(StudentScoreImpl.class);

    private TransactionTemplate transactionTemplate;

    private StudentScoreMapper studentScoreMapper;

    @Override
    public ApiResponse<Boolean> saveScore(StudentScoreParam studentScoreParam) {
        return transactionTemplate.execute(transactionStatus->{
           try{
               StudentScore studentScore = StudentScore.builder()
                       .uuid(studentScoreParam.getUuid())
                       .score1(studentScoreParam.getScore1())
                       .score2(studentScoreParam.getScore2())
                       .score3(studentScoreParam.getScore3())
                       .score4(studentScoreParam.getScore4())
                       .score5(studentScoreParam.getScore5())
                       .score6(studentScoreParam.getScore6())
                       .studentType(studentScoreParam.getStudentType())
                       .scoreType(studentScoreParam.getScoreType())
                       .build();
               studentScoreMapper.insert(studentScore);
           }catch (Exception e){
               LOG.error("保存学生分数信息出错");
               // insert语句执行出错事务回滚
               transactionStatus.setRollbackOnly();
               ResponseUtil.error(ErrorCode.DATA_INSERT_ERROR);
           }
            return ResponseUtil.success(Boolean.TRUE);
        });
    }

    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Autowired
    public void setCbSlopeBaseMapper(StudentScoreMapper studentScoreMapper) {
        this.studentScoreMapper = studentScoreMapper;
    }


}