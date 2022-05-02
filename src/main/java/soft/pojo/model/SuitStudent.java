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
@TableName(value = "suit_student")
public class SuitStudent{

    /** 主键*/
    @TableId
    private Long id;

    /** 关联学生信息外键*/
    @TableField
    private Long studentId;

    /** 关联老师信息外键*/
    @TableField
    private Long teacherId;

    /** 学生总分数*/
    @TableField
    private Integer totalScore;

    /** 学校最低分数线*/
    @TableField
    private Integer schoolScoreLine;
}
