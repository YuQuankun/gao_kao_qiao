package soft.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.annotaion.RequestPostSingleParam;
import soft.common.ApiResponse;
import soft.pojo.model.StudentInfo;
import soft.pojo.param.StudentInfoParam;
import soft.service.IStudentInfoService;

/**
 * @author kun_mi
 */
@RestController
@RequestMapping(value = "/studentInfo")
public class StudentInfoController {

    @Autowired
    private IStudentInfoService iStudentInfoService;

    @Operation(description = "保存学生信息")
    @PostMapping(value = "/saveStudentInfo")
    @ResponseBody
    public ApiResponse<Long> saveStudentInfo(@RequestBody @Validated StudentInfoParam studentInfoParam){
        return iStudentInfoService.saveStudentInfo(studentInfoParam);
    }

    @Operation(description = "根据ID查询学生信息")
    @PostMapping(value = "/getStudentInfo")
    @ResponseBody
    public ApiResponse<StudentInfo> getStudentInfo(@RequestPostSingleParam Integer id){
        return iStudentInfoService.getStudentInfo(id);
    }
}