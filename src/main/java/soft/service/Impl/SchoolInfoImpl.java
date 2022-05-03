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
import soft.mapper.SchoolInfoMapper;
import soft.pojo.model.SchoolInfo;
import soft.pojo.param.SchoolInfoParam;
import soft.service.ISchoolInfoService;
import soft.util.ResponseUtil;

/**
 * @author kun_mi
 */
@Service
public class SchoolInfoImpl extends ServiceImpl<SchoolInfoMapper, SchoolInfo> implements ISchoolInfoService, ErrorCode {

    private static final Logger LOG = LoggerFactory.getLogger(SchoolInfoImpl.class);

    private TransactionTemplate transactionTemplate;

    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public ApiResponse<Boolean> save(SchoolInfoParam schoolInfoParam) {
        return transactionTemplate.execute(transactionStatus->{
            try{
                SchoolInfo schoolInfo = SchoolInfo.builder()
                        .name(schoolInfoParam.getName())
                        .minScore(schoolInfoParam.getMinScore())
                        .description(schoolInfoParam.getDescription())
                        .logoUrl(schoolInfoParam.getLogoUrl())
                        .build();
                schoolInfoMapper.insert(schoolInfo);
            }catch (Exception e){
                LOG.error("报错学校信息错误");
                transactionStatus.setRollbackOnly();
                ResponseUtil.error(ErrorCode.DATA_INSERT_ERROR);
            }
            return ResponseUtil.success(Boolean.TRUE);
        });
    }

    @Override
    public ApiResponse<SchoolInfo> get(String name) {
        QueryWrapper<SchoolInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return ResponseUtil.success(schoolInfoMapper.selectOne(wrapper));
    }

    @Autowired
    public void setTransactionTemplate(TransactionTemplate  transactionTemplate){
        this.transactionTemplate = transactionTemplate;
    }

    @Autowired
    public void setSchoolInfoMapper(SchoolInfoMapper schoolInfoMapper){
        this.schoolInfoMapper = schoolInfoMapper;
    }
}
