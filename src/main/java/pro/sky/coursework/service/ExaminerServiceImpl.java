package pro.sky.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.coursework.Question;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionServiceImpl questionService;

    @Autowired
    ExaminerServiceImpl(QuestionServiceImpl questionService){
        this.questionService = questionService;
    }

    public Map<Integer, Question> getQuestions(int amount) throws ResponseStatusException {
        if (amount > questionService.getQuestions().size()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Некорректный запрос");
        }
        Map<Integer, Question> questions = new HashMap<>();
        for (int i = 0; i < amount; i++){
            int keyQuestion = questionService.getRandomQuestion();
            if (questions.isEmpty()){
                questions.put(questions.size() + 1, questionService.getQuestions().get(keyQuestion));
            }
            else {
                if (!questions.containsValue(questionService.getQuestions().get(keyQuestion))){
                    questions.put(questions.size() + 1, questionService.getQuestions().get(keyQuestion));
                }
            }
        }
        return questions;
    }

}
