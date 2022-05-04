package soft.controller;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.annotaion.RequestPostSingleParam;
import soft.common.ApiResponse;
import soft.pojo.model.SchoolInfo;
import soft.pojo.model.StudentSchool;
import soft.pojo.param.StudentSchoolParam;
import soft.service.IStudentSchoolService;

import java.util.List;

/**
 * @author kun_mi
 */
@RestController
@RequestMapping("/studentSchool")
public class StudentSchoolController {

    @Autowired
    private IStudentSchoolService iStudentSchoolService;

    @Operation(description = "保存学生意向学校信息")
    @PostMapping("/save")
    @ResponseBody
    public ApiResponse<Boolean> save(@RequestBody @Validated StudentSchoolParam studentSchoolParam){
        return iStudentSchoolService.save(studentSchoolParam);
    }

    @Operation(description = "查询学生意向学校")
    @PostMapping("/get")
    @ResponseBody
    public ApiResponse<List<StudentSchool>> get(@RequestPostSingleParam Long studentUuid){
        return iStudentSchoolService.get(studentUuid);
    }
}
