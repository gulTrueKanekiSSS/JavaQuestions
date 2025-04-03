package pro.sky.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.coursework.Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionServiceImpl questionService;

    @Autowired
    ExaminerServiceImpl(QuestionServiceImpl questionService){
        this.questionService = questionService;
    }

    public Set<Question> getQuestions(int amount) throws ResponseStatusException {
        if (amount > questionService.getQuestions().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Некорректный запрос");
        }

        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            int keyQuestion = questionService.getRandomQuestion();
            Question q = questionService.getQuestions().get(keyQuestion);
            questions.add(q);
        }

        return questions;
    }

}
