package pro.sky.coursework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.coursework.Question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTests {

    private QuestionServiceImpl questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp(){
        questionService = mock(QuestionServiceImpl.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void shouldReturnQuestion() {

        Map<Integer, Question> mockQuestions = new HashMap<>();
        mockQuestions.put(1, new Question("Question", "Answer"));

        when(questionService.getQuestions()).thenReturn(mockQuestions);
        when(questionService.getRandomQuestion()).thenReturn(1);

        Set<Question> result = examinerService.getQuestions(1);

        assertEquals(1, result.size());
        assertTrue(result.contains(mockQuestions.get(1)));
    }

    @Test
    void shouldThrowBadRequest(){
        Map<Integer, Question> mockQuestions = new HashMap<>();

        mockQuestions.put(1, new Question("test", "test"));

        when(questionService.getQuestions()).thenReturn(mockQuestions);

        assertThrows(ResponseStatusException.class, () -> {examinerService.getQuestions(3);});
    }


}
