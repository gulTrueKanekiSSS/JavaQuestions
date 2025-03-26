package pro.sky.coursework.service;

import pro.sky.coursework.Question;

import java.util.Map;

public interface ExaminerService {
    Map<Integer, Question> getQuestions(int amount);
}
