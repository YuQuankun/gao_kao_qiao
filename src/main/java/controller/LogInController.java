package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kun_mi
 */
@Controller
public class LogInController {

    // 你的修改  先pull  再Commit  勾选自己刚刚改过的代码所在的文件名 比如LogInController 其余的不勾 ，点击Commit and Push   文件名应该从蓝色变成了白色
    @Autowired
    public List<Integer> getInfo(){
        List<Integer> example = new ArrayList<>();
        return example;
    }
}
