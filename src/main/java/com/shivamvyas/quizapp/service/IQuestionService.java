package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.exception.QuestionNotFoundException;
import com.shivamvyas.quizapp.model.Question;
import java.util.List;

public interface IQuestionService {
    List<Question> getQuestions();
    List<String> showCategoriesList();
    List<Question> getQuestionsByCategory(String category);
    String addQuestion(Question question);
    Question getQuestionById(Long id);
    String updateQuestion(Long id, Question question);
    String deleteQuestion(Long id);
}
