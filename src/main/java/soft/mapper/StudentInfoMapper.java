package soft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import soft.pojo.model.StudentInfo;

/**
 * @author kun_mi
 */
@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {


}
