package soft.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.annotaion.RequestPostSingleParam;
import soft.common.ApiResponse;
import soft.pojo.model.SchoolInfo;
import soft.pojo.param.SchoolInfoParam;
import soft.service.ISchoolInfoService;

/**
 * @author kun_mi
 */
@RestController
@RequestMapping("/schoolInfo")
public class SchoolInfoController {

    @Autowired
    private ISchoolInfoService iSchoolInfoService;

    @Operation(description = "保存学校信息")
    @PostMapping("/save")
    @ResponseBody
    public ApiResponse<Boolean> save(@RequestBody @Validated SchoolInfoParam schoolInfoParam){
        return iSchoolInfoService.save(schoolInfoParam);
    }

    @Operation(description = "获取学校信息")
    @PostMapping("/get")
    @ResponseBody
    public ApiResponse<SchoolInfo> get(@RequestPostSingleParam String name){
        return iSchoolInfoService.get(name);
    }
}
