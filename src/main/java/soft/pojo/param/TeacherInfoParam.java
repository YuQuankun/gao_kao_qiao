package soft.pojo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentScoreParam {

    /** 主键*/
    @Schema(description = "主键",required = false)
    private Long id;

    /** 姓名*/
    @NotBlank
    @Schema(description = "姓名",required = true)
    private String name;

    /**  学校*/
    @NotBlank
    @Schema(description = "学校",required = true)
    private String school;

    /** 学院*/
    @NotBlank
    @Schema(description = "学院",required = true)
    private String faculty;

    /**  电话*/
    @NotBlank
    @Schema(description = "电话",required = true)
    private String phoneNumber;

    /**  职称*/
    @NotBlank
    @Schema(description = "职称",required = true)
    private String professional;

    /**  职务*/
    @NotBlank
    @Schema(description = "职务",required = true)
    private String occupation;

    /**  教师类型*/
    @NotBlank
    @Schema(description = "教师类型",required = true)
    private String teacherType;
}
