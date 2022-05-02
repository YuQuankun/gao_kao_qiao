package soft.pojo.model;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName(value = "student_score")
public class StudentScore {

    /** 主键*/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 关联学生信息uuid */
    @TableField
    private Long uuid;

    /** 分数1 */
    @TableField
    private Integer score1;

    /** 分数2 */
    @TableField
    private Integer score2;

    /** 分数3 */
    @TableField
    private Integer score3;

    /** 分数4 */
    @TableField
    private Integer score4;

    /** 分数5 */
    @TableField
    private Integer score5;

    /** 分数6 */
    @TableField
    private Integer score6;

    /**学生类型 0-理科 1-文科*/
    @TableField
    private Integer studentType;

    /** 分数类型*/
    @TableField
    private String scoreType;
}
