package pro.sky.coursework.service;

import pro.sky.coursework.Question;

import java.util.Map;

public interface QuestionService {
    Map<Integer, Question> getQuestions();
    Question addQuestion(String question, String answer);
    Question deleteQuestion(String question, String answer);
}
