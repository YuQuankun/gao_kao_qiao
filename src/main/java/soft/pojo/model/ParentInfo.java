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
@TableName(value = "parent_info")
public class ParentInfo {

    /** 主键*/
    @TableId
    private Long id;

    /** 关联学生信息外键 */
    @TableField
    private Long guid;

    /** 姓名 */
    @TableField
    private String name;

    /** 电话 */
    @TableField
    private String phoneNumber;

    /** 认证状态 0-未认证  1-认证通过 */
    @TableField
    private Integer identifyState;

    /** 认证教师id */
    @TableField
    private Integer identifyTeacherId;

}
