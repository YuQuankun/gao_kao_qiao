package soft.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.common.ApiResponse;
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

    @Operation(description = "报错教师信息接口")
    @PostMapping("/save")
    @ResponseBody
    public ApiResponse<Boolean> save(@RequestBody @Validated TeacherInfoParam teacherInfoParam){
        return  iTeacherInfoService.saveTeacherInfo(teacherInfoParam);
    }



}
