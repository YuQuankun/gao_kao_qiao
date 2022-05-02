package soft.pojo.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author kun_mi
 */
@Data
public class TeacherInfoParam {
    /** 主键*/
    @Schema(description = "主键" , required = false)
    private Long id;

    /** uuid */
    @NotBlank
    @Schema(description = "用户uuid" , required = true)
    private Long uuid;

    /** 姓名 */
    @NotNull
    @Schema(description = "教师姓名" , required = true)
    private String name;

    /** 学校 */
    @NotNull
    @Schema(description = "教师所在学校" , required = true)
    private String school;

    /** 学院 */
    @NotNull
    @Schema(description = "教师所在学院名称", required = true)
    private String faculty;

    /** 电话 */
    @NotNull
    @Schema(description = "教师电话", required = true)
    private String phoneNumber;

    /** 职称*/
    @NotNull
    @Schema(description = "教师职称",required = true)
    private String professional;

    /** 职务*/
    @NotNull
    @Schema(description = "教师职务",required = true)
    private String occupation;

    /** 教师类型*/
    @NotNull
    @Schema(description = "教师类型 大学教师or高中教师")
    private String teacherType;
}