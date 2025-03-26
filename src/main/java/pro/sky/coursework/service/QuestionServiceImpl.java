package pro.sky.coursework.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework.Question;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService{
    Map<Integer, Question> questions = new HashMap<>();
    Random random = new Random();

    public QuestionServiceImpl() {
        questions.put(1, new Question("Какое самое большое млекопитающее?", "Кит"));
        questions.put(2, new Question("Какой сегодня год?", "2025"));
    }

    public int getRandomQuestion(){
        List<Integer> keys = new ArrayList<>(questions.keySet());
        return keys.get(random.nextInt(keys.size()));
    }

    @Override
    public Map<Integer, Question> getQuestions(){
        return questions;
    }

    @Override
    public void addQuestion(String question, String answer){
        Integer pk = questions.size() + 1;
        questions.put(pk, new Question(question, answer));
    }

    @Override
    public void deleteQuestion(String question, String answer){
        questions.entrySet().removeIf(q -> q.getValue().getQuestion().equals(question) && q.getValue().getAnswer().equals(answer));
    }
}
