package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.model.Question;
import com.shivamvyas.quizapp.repo.IQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionRepo repo;

    @Override
    public List<Question> getQuestions() {
        return repo.findAll();
    }
}
