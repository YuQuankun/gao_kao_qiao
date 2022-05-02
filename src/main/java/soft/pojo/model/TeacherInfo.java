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
@TableName(value = "teacher_info")
public class TeacherInfo {

    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 用户uuid */
    @TableField
    private Long uuid;

    /** 姓名 */
    @TableField
    private String name;

    /** 学校 */
    @TableField
    private String school;

    /** 学院 */
    @TableField
    private String faculty;

    /** 电话  */
    @TableField
    private String phoneNumber;

    /** 职称 */
    @TableField
    private String professional;

    /** 职务 */
    @TableField
    private String occupation;

    /** 教师类型 */
    @TableField
    private String teacherType;
}
