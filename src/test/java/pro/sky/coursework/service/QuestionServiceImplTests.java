package pro.sky.coursework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework.Question;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        questionService = new QuestionServiceImpl();
    }

    @Test
    void testInitialQuestionsSize() {
        Map<Integer, Question> questions = questionService.getQuestions();
        assertEquals(2, questions.size());
    }

    @Test
    void testAddQuestion() {
        questionService.addQuestion("Сколько будет 2+2?", "4");
        assertEquals(3, questionService.getQuestions().size());
    }

    @Test
    void testDeleteExistingQuestion() {
        questionService.deleteQuestion("Какое самое большое млекопитающее?", "Кит");
        assertEquals(1, questionService.getQuestions().size());
    }

    @Test
    void testDeleteNonExistingQuestion() {
        questionService.deleteQuestion("Несуществующий вопрос", "Ответ");
        assertEquals(2, questionService.getQuestions().size());
    }

    @Test
    void testGetRandomQuestionReturnsValidKey() {
        int key = questionService.getRandomQuestion();
        assertTrue(questionService.getQuestions().containsKey(key));
    }
}
