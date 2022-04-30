package soft.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import soft.common.ApiResponse;
import soft.constant.ErrorCode;
import soft.mapper.StudentInfoMapper;
import soft.pojo.model.StudentInfo;
import soft.pojo.param.StudentInfoParam;
import soft.service.IStudentInfoService;
import soft.util.ResponseUtil;

/**
 * @author kun_mi
 */

@Service
public class StudentInfoImpl extends ServiceImpl<StudentInfoMapper,StudentInfo> implements IStudentInfoService, ErrorCode {

    private static final Logger LOG = LoggerFactory.getLogger(StudentInfoImpl.class);

    private TransactionTemplate transactionTemplate;

    private StudentInfoMapper studentInfoMapper;

    public StudentInfoImpl() {
    }

    @Override
    public ApiResponse<Boolean> saveStudentInfo(StudentInfoParam studentInfoParam) {
        return transactionTemplate.execute(transactionStatus->{
            try{
                StudentInfo studentInfo = StudentInfo.builder()
                        .name(studentInfoParam.getName())
                        .school(studentInfoParam.getSchool())
                        .className(studentInfoParam.getClassName())
                        .phoneNumber(studentInfoParam.getPhoneNumber())
                        .identifyState(studentInfoParam.getIdentifyState())
                        .identifyTeacherId(studentInfoParam.getIdentifyTeacherId())
                        .build();
                studentInfoMapper.insert(studentInfo);
            }catch (Exception e){
                LOG.error("保存学生个人信息异常");
                transactionStatus.setRollbackOnly();
                return ResponseUtil.error(DATA_INSERT_ERROR);
            }
            return ResponseUtil.success(Boolean.TRUE);
        });
    }

}
