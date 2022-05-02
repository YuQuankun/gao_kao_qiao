package soft.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import soft.annotaion.RequestPostSingleParam;
import soft.common.ApiResponse;
import soft.pojo.model.StudentScore;
import soft.pojo.param.StudentScoreParam;
import soft.service.IStudentScoreService;

import java.util.List;

/**
 * 学生-分数控制器
 * @author kun_mi
 */

@RestController
@RequestMapping("/StudentScore")
public class StudentScoreController {

    @Autowired
    private IStudentScoreService iStudentScoreService;


    @Operation(description = "查询学生成绩相关接口")
    @PostMapping("/getScore")
    @ResponseBody
    public ApiResponse<List<StudentScore>> getScore(@RequestPostSingleParam Long uuid){
        return iStudentScoreService.getScore(uuid);
    }

    @Operation(description = "保存学生成绩相关接口")
    @PostMapping("/saveScore")
    @ResponseBody
    public ApiResponse<Boolean> saveScore(@RequestBody StudentScoreParam studentScoreParam){
        return iStudentScoreService.saveScore(studentScoreParam);
    }
}
