package pro.sky.coursework.service;

import pro.sky.coursework.Question;

import java.util.Map;

public interface QuestionService {
    Map<Integer, Question> getQuestions();
    void addQuestion(String question, String answer);
    void deleteQuestion(String question, String answer);
}
