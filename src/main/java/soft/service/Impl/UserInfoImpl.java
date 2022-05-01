package soft.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import soft.common.ApiResponse;
import soft.constant.ErrorCode;
import soft.mapper.StudentInfoMapper;
import soft.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import soft.pojo.model.UserInfo;
import soft.pojo.param.UserInfoParam;
import soft.service.IUserInfoService;
import soft.util.HttpRequestUtil;
import soft.util.ResponseUtil;

import java.util.List;

/**
 * @author kun_mi
 */
@Service
public class UserInfoImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements IUserInfoService, ErrorCode  {

    private static final Logger LOG = LoggerFactory.getLogger(UserInfoImpl.class);

    private TransactionTemplate transactionTemplate;

    private StudentInfoMapper studentInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private HttpRequestUtil httpRequestUtil;

    @Value("${app.appId}")
    private String appId;

    @Value("${app.secret}")
    private String appSecret;


    @Override
    public ApiResponse<String> getOpenId(String code) {
        return ResponseUtil.success(httpRequestUtil.getOpenId(appId,appSecret,code));
    }

    @Override
    public ApiResponse<UserInfo> getInfo(Long uuid) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id",uuid);
        return ResponseUtil.success(userInfoMapper.selectOne(wrapper));
    }

    @Override
    public ApiResponse<Long> saveInfo(UserInfoParam userInfoParam){

        return transactionTemplate.execute(transactionStatus->{
            Long uuid = 0L;
            try{
                UserInfo userInfo = UserInfo.builder()
                        .userName(userInfoParam.getUserName())
                        .userType(userInfoParam.getUserType())
                        .userId(userInfoParam.getUserId())
                        .account(userInfoParam.getAccount())
                        .password(userInfoParam.getPassword())
                        .logoUrl(userInfoParam.getLogoUrl())
                        .build();
                userInfoMapper.insert(userInfo);
                uuid = userInfo.getId();
            }catch (Exception e){
                LOG.error("保存用户信息错误");
                transactionStatus.setRollbackOnly();
                return ResponseUtil.error(DATA_INSERT_ERROR);
            }
            return ResponseUtil.success(uuid);
        });
    }

    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Autowired
    public void setCbSlopeBaseMapper(StudentInfoMapper studentInfoMapper) {
        this.studentInfoMapper = studentInfoMapper;
    }
}