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

    /** 关联学生信息外键 */
    @NotBlank
    @Schema(description = "关联学生信息外键",required = true)
    private Long guid;

    /**  分数1*/
    @NotBlank
    @Schema(description = "分数1",required = true)
    private Integer score1;

    /**  分数2*/
    @NotBlank
    @Schema(description = "分数2",required = true)
    private Integer score2;

    /**  分数3*/
    @NotBlank
    @Schema(description = "分数3",required = true)
    private Integer score3;

    /**  分数4*/
    @NotBlank
    @Schema(description = "分数4",required = true)
    private Integer score4;

    /**  分数5*/
    @NotBlank
    @Schema(description = "分数5",required = true)
    private Integer score5;

    /**  分数6*/
    @NotBlank
    @Schema(description = "分数6",required = true)
    private Integer score6;

    /**  分数类型*/
    @NotBlank
    @Schema(description = "分数类型",required = true)
    private Integer scoreType;
}
