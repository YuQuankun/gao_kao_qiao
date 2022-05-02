package soft.pojo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SuitStudentParam{

    /** 主键*/
    @Schema(description = "主键",required = false)
    private Long id;

    /** 关联学生信息外键*/
    @NotBlank
    @Schema(description = "关联学生信息外键",required = true)
    private Long studentId;

    /** 关联老师信息外键*/
    @NotBlank
    @Schema(description = "关联老师信息外键",required = true)
    private Long teacherId;

    /**  学生总分数*/
    @NotBlank
    @Schema(description = "学生总分数",required = true)
    private Integer totalScore;

    /** 学生最低分数线*/
    @NotBlank
    @Schema(description = "学生最低分数线",required = true)
    private Long schoolScoreLine;
}
