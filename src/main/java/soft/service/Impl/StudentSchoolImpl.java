package soft.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import soft.common.ApiResponse;
import soft.constant.ErrorCode;
import soft.mapper.StudentSchoolMapper;
import soft.pojo.model.StudentSchool;
import soft.pojo.param.StudentSchoolParam;
import soft.pojo.param.StudentScoreParam;
import soft.service.IStudentSchoolService;
import soft.util.ResponseUtil;

import java.util.List;

/**
 * @author kun_mi
 */
@Service
public class StudentSchoolImpl extends ServiceImpl<StudentSchoolMapper, StudentSchool> implements IStudentSchoolService, ErrorCode {

    private static final Logger LOG = LoggerFactory.getLogger(StudentSchoolImpl.class);

    private TransactionTemplate transactionTemplate;

    private StudentSchoolMapper studentSchoolMapper;

    @Override
    public ApiResponse<Boolean> save(StudentSchoolParam studentSchoolParam) {
        return transactionTemplate.execute(transactionStatus->{
            try {
                StudentSchool school = StudentSchool.builder()
                        .studentId(studentSchoolParam.getStudentId())
                        .schoolName(studentSchoolParam.getSchoolName())
                        .build();
                studentSchoolMapper.insert(school);
            }catch (Exception e){
                LOG.error("插入学生意向学校表失败");
                transactionStatus.setRollbackOnly();
                return ResponseUtil.error(ErrorCode.DATA_INSERT_ERROR);
            }
            return ResponseUtil.success(Boolean.TRUE);
        });
    }

    @Override
    public ApiResponse<List<StudentSchool>> get(Long studentUuid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("student_id",studentUuid);
        return ResponseUtil.success(studentSchoolMapper.selectList(wrapper));
    }

    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate){
        this.transactionTemplate = transactionTemplate;
    }
    @Autowired
    public void setStudentSchoolMapper(StudentSchoolMapper studentSchoolMapper){
        this.studentSchoolMapper = studentSchoolMapper;
    }


}