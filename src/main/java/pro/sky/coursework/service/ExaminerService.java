package pro.sky.coursework.service;

import pro.sky.coursework.Question;
import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
