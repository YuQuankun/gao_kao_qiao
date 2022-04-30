package soft.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soft.common.ApiResponse;
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
    public ApiResponse<Boolean> saveStudentInfo(@RequestBody @Validated StudentInfoParam studentInfoParam){
        return iStudentInfoService.saveStudentInfo(studentInfoParam);
    }
}
