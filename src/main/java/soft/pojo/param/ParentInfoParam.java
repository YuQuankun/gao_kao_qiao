package soft.pojo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ParentInfoParam {

    /** 主键*/
    @Schema(description = "主键",required = false)
    private Long id;

    /** 关联学生信息外键 */
    @NotBlank
    @Schema(description = "用户uuid",required = true)
    private Long uuid;

    /**  姓名*/
    @NotBlank
    @Schema(description = "姓名",required = true)
    private String name;

    /** 电话 */
    @NotBlank
    @Schema(description = "电话",required = true)
    private String phoneNumber;

    /** 认证状态 0-未认证  1-认证通过 */
    @NotNull
    @Schema(description = "认证状态",required = true)
    private Integer identifyState;

    /** 认证教师id */
    @NotNull
    @Schema(description = "认证教师id",required = true)
    private Integer identifyTeacherId;
}
