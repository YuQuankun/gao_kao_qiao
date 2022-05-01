package soft.pojo.param;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author kun_mi
 */

@Data
public class UserInfoParam {

    @Schema(description = "主键",required = false)
    private Long id;

    @NotNull
    @Schema(description = "用户名", required = true)
    private String userName;

    @NotNull
    @Schema(description = "用户类型",required = true)
    private Integer userType;

    @NotNull
    @Schema(description = "用户openId",required = true)
    private String userId;

    @NotBlank
    @Schema(description = "账号",required = true)
    private String account;

    @NotNull
    @Schema(description = "密码",required = true)
    private String password;

    @NotNull
    @Schema(description = "头像图片存储地址",required = true)
    private Integer logoUrl;
}