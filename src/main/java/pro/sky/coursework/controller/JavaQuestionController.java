package pro.sky.coursework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework.Question;
import pro.sky.coursework.service.QuestionServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionServiceImpl questionService;

    JavaQuestionController(QuestionServiceImpl questionService){
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "question", required = true) String question,
                              @RequestParam(value = "answer") String answer){
        return questionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Question deleteQuestion(@RequestParam(value="question") String question,
                                 @RequestParam(value = "answer") String answer){
        return questionService.deleteQuestion(question, answer);
    }

    @GetMapping("/")
    public Map<Integer, Question> getQuestions(){
        return questionService.getQuestions();
    }
}
