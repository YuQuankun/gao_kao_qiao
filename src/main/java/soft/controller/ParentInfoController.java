package soft.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.annotaion.RequestPostSingleParam;
import soft.common.ApiResponse;
import soft.pojo.model.ParentInfo;
import soft.pojo.param.ParentInfoParam;
import soft.service.IParentInfoService;

import java.util.logging.Logger;


/**
 * @author kun_mi
 */
@RestController
@RequestMapping("/parentInfo")
public class ParentInfoController {

    @Autowired
    private IParentInfoService iParentInfoService;

    @Operation(description = "保存学生家长信息")
    @PostMapping("/save")
    @ResponseBody
    public ApiResponse<Boolean> save(@RequestBody @Validated ParentInfoParam param){
        return iParentInfoService.save(param);
    }

    @Operation(description = "获取学生家长信息")
    @PostMapping("/get")
    @ResponseBody
    public ApiResponse<ParentInfo> get(@RequestPostSingleParam Long uuid){
        return iParentInfoService.get(uuid);
    }

}
