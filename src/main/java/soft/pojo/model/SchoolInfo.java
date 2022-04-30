package soft.pojo.model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "school_info")
public class SchoolInfo {

    /** 主键*/
    @TableId
    private Long id;

    /** 姓名 */
    @TableField
    private String name;

    /**  最低分数线*/
    @TableField
    private Integer minScore;

    /** 学校描述*/
    @TableField
    private String description;

    /**  学校logo存储地址*/
    @TableField
    private String logoUrl;
}
