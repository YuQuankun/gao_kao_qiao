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
import soft.mapper.TeacherInfoMapper;
import soft.pojo.model.TeacherInfo;
import soft.pojo.param.TeacherInfoParam;
import soft.service.ITeacherInfoService;
import soft.util.ResponseUtil;

/**
 * @author kun_mi
 */
@Service
public class TeacherInfoImpl extends ServiceImpl<TeacherInfoMapper, TeacherInfo> implements ITeacherInfoService, ErrorCode {

    private static final Logger LOG = LoggerFactory.getLogger(TeacherInfo.class);

    private TeacherInfoMapper teacherInfoMapper;

    private TransactionTemplate transactionTemplate;


    @Override
    public ApiResponse<Boolean> saveTeacherInfo(TeacherInfoParam teacherInfoParam) {
        return transactionTemplate.execute(transactionStatus->{
            try{
                TeacherInfo teacherInfo = TeacherInfo.builder()
                        .uuid(teacherInfoParam.getUuid())
                        .name(teacherInfoParam.getName())
                        .school(teacherInfoParam.getSchool())
                        .faculty(teacherInfoParam.getFaculty())
                        .phoneNumber(teacherInfoParam.getPhoneNumber())
                        .professional(teacherInfoParam.getProfessional())
                        .occupation(teacherInfoParam.getOccupation())
                        .teacherType(teacherInfoParam.getTeacherType())
                        .build();
                teacherInfoMapper.insert(teacherInfo);
            }catch (Exception e){
                LOG.error("保存教师信息报错");
                transactionStatus.setRollbackOnly();
                ResponseUtil.error(ErrorCode.DATA_INSERT_ERROR);
            }
            return ResponseUtil.success(Boolean.TRUE);
        });
    }

    @Override
    public ApiResponse<TeacherInfo> getTeacherInfo(Long uuid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uuid", uuid);
        return ResponseUtil.success(teacherInfoMapper.selectOne(wrapper));
    }

    @Autowired
    public void setTeacherInfoMapper(TeacherInfoMapper teacherInfoMapper){
        this.teacherInfoMapper = teacherInfoMapper;
    }
    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate){
        this.transactionTemplate = transactionTemplate;
    }


}
