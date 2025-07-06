package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.model.QuestionClient;
import com.shivamvyas.quizapp.model.Response;
import java.util.List;

public interface IQuizService {
    String createQuiz(String category, int numOfQues, String title);
    List<QuestionClient> getQuizQuestions(Long id);
    String calculateResult(Long id, List<Response> responses);
}
