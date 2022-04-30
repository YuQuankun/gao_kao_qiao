package soft.pojo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author kun_mi
 */
@Data
public class StudentInfoParam {

    /** 主键*/
    @Schema(description = "主键",required = false)
    private Long id;

    /** 姓名 */
    @NotBlank
    @Schema(description = "姓名",required = true)
    private String name;

    /** 学校名 */
    @NotBlank
    @Schema(description = "学校名称",required = true)
    private String school;

    /** 班级 */
    @NotBlank
    @Schema(description = "班级",required = true)
    private String className;

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
