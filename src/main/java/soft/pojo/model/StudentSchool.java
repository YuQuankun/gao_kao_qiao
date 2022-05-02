package soft.pojo.model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "student_school")
public class StudentSchool{

    /** 主键*/
    @TableId
    private Long id;

    /** 关联学生信息外键*/
    @TableField
    private Long studentId;

    /**  意向学校名*/
    @TableField
    private String schoolName;
}
