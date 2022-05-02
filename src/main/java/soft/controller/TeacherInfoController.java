package soft.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.annotaion.RequestPostSingleParam;
import soft.common.ApiResponse;
import soft.pojo.model.TeacherInfo;
import soft.pojo.param.TeacherInfoParam;
import soft.service.ITeacherInfoService;

/**
 * @author kun_mi
 */
@RestController
@RequestMapping("/teacherInfo")
public class TeacherInfoController {


    @Autowired
    private ITeacherInfoService iTeacherInfoService;

    @Operation(description = "保存教师信息接口")
    @PostMapping("/save")
    @ResponseBody
    public ApiResponse<Boolean> save(@RequestBody @Validated TeacherInfoParam teacherInfoParam){
        return  iTeacherInfoService.saveTeacherInfo(teacherInfoParam);
    }

    @Operation(description = "获取教师信息接口")
    @PostMapping("/get")
    @ResponseBody
    public ApiResponse<TeacherInfo> save(@RequestPostSingleParam Long uuid){
        return  iTeacherInfoService.getTeacherInfo(uuid);
    }

}
