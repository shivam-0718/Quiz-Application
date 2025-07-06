package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.model.Question;
import java.util.List;

public interface IQuestionService {
    List<Question> getQuestions();
}
