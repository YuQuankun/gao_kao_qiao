package soft.pojo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentSchoolParam{

    /** 主键*/
    @Schema(description = "主键",required = false)
    private Long id;

    /** 关联学生信息外键*/
    @NotNull
    @Schema(description = "关联学生信息外键",required = true)
    private Long studentId;

    /**  意向学校名*/
    @NotBlank
    @Schema(description = "意向学校名",required = true)
    private String schoolName;
}
