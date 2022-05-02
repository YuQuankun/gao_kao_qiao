package soft.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author kun_mi
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user_info")
public class UserInfo {

    /** 主键*/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 用户名*/
    @TableField
    private String userName;

    /** 用户类型   - 1大学教师 -2高中教师 -3学生 -4家长 */
    @TableField
    private Integer userType;

    /** 用户OpenId,唯一标识符  */
    @TableField
    private String  userId;

    /** 用户账号 */
    @TableField
    private String account;

    /** 用户密码 */
    @TableField
    private String password;

    /** 用户头像存储url */
    @TableField
    private String logoUrl;
}