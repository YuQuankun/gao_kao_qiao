package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kun_mi
 */

@RestController

public class LogInController {


    @Autowired
    public List<Integer> getInfo(){
        List<Integer> example = new ArrayList<>();
        return example;
    }
}
