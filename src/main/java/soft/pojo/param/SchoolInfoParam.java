package soft.pojo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author kun_mi
 */
@Data
public class SchoolInfoParam{

    /** 主键*/
    @Schema(description = "主键",required = false)
    private Long id;

    /** 姓名*/
    @NotBlank
    @Schema(description = "姓名",required = true)
    private String name;

    /**  最低分数线*/
    @NotNull
    @Schema(description = "最低分数线",required = true)
    private Integer minScore;

    /** 学校描述*/
    @NotBlank
    @Schema(description = "学校描述",required = true)
    private String description;

    /**  学校logo存储地址*/
    @NotBlank
    @Schema(description = "电话",required = true)
    private String logoUrl;
}
