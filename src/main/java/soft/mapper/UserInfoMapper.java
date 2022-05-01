package soft.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import soft.pojo.model.UserInfo;
import java.util.List;

/**
 * @author kun_mi
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{

    /**
     *
     * @return
     */
    UserInfo selectInfo();
}