package soft.pojo.model;

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
    @TableId
    private Long id;

    /** 用户名*/
    @TableField
    private String userName;

    /** 用户类型   -教师 -学生 -家长 */
    @TableField
    private String userType;

    /** 用户Id */
    @TableField
    private Long userId;

    /** 用户账号 */
    @TableField
    private String account;

    /** 用户密码 */
    @TableField
    private String password;

    @TableField
    private String logoUrl;
}
