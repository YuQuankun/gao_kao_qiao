package mapper;


import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pojo.model.UserInfo;

/**
 * @author kun_mi
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{
}
