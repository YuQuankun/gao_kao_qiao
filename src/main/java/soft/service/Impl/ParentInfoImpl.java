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
import soft.mapper.ParentInfoMapper;
import soft.pojo.model.ParentInfo;
import soft.pojo.param.ParentInfoParam;
import soft.service.IParentInfoService;
import soft.util.ResponseUtil;


/**
 * @author kun_mi
 */
@Service
public class ParentInfoImpl extends ServiceImpl<ParentInfoMapper, ParentInfo> implements IParentInfoService, ErrorCode {

    private static final Logger LOG = LoggerFactory.getLogger(ParentInfoImpl.class);

    private TransactionTemplate transactionTemplate;

    private ParentInfoMapper parentInfoMapper;

    @Override
    public ApiResponse<Boolean> save(ParentInfoParam param) {
        return transactionTemplate.execute(transactionStatus->{
            try{
                ParentInfo parentInfo = ParentInfo.builder()
                        .uuid(param.getUuid())
                        .studentUuid(param.getStudentUuid())
                        .name(param.getName())
                        .phoneNumber(param.getPhoneNumber())
                        .identifyState(param.getIdentifyState())
                        .identifyTeacherId(param.getIdentifyTeacherId())
                        .build();
                parentInfoMapper.insert(parentInfo);
            }catch (Exception e){
                LOG.error("报错学生家长信息错误");
                transactionStatus.setRollbackOnly();
                return ResponseUtil.error(ErrorCode.DATA_INSERT_ERROR);
            }
            return ResponseUtil.success(Boolean.TRUE);
        });
    }

    @Override
    public ApiResponse<ParentInfo> get(Long uuid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uuid" , uuid);
        return ResponseUtil.success(parentInfoMapper.selectOne(wrapper));
    }


    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate){
        this.transactionTemplate = transactionTemplate;
    }
    @Autowired
    public void setParentInfoMapper(ParentInfoMapper parentInfoMapper){
        this.parentInfoMapper = parentInfoMapper;
    }


}
