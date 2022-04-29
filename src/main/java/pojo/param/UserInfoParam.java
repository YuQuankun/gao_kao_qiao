package pojo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
/**
 * @author kun_mi
 */

@Data
public class UserInfoParam {

    @Schema(description = "主键",required = false)
    private Long id;

    @Schema(description = "用户名", required = true)
    private String userName;


}
