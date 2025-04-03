package pro.sky.coursework.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework.Question;
import pro.sky.coursework.service.ExaminerServiceImpl;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    ExamController(ExaminerServiceImpl examinerService){
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }

}
