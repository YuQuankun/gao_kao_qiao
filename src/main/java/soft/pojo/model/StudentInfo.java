package soft.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kun_mi
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "student_info")
public class StudentInfo {

    /** 主键*/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 用户uuid */
    @TableField
    private Long  uuid;

    /** 姓名 */
    @TableField
    private String name;

    /** 学校名 */
    @TableField
    private String school;

    /** 班级 */
    @TableField
    private String className;

    /** 电话 */
    @TableField
    private String phoneNumber;

    /** 认证状态 0-未认证  1-认证通过 */
    @TableField
    private Integer identfyState;

    /** 认证教师id */
    @TableField
    private Integer identfyTeacherId;

}
