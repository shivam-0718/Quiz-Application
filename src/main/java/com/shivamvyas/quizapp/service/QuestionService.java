package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.model.Question;
import com.shivamvyas.quizapp.repo.IQuestionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionRepo repo;

    @Override
    public List<Question> getQuestions() {
        return repo.findAll();
    }

    @Override
    public List<String> showCategoriesList() {
        return repo.showCategories();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        List<Question> questions = repo.findByCategory(category);
        questions.forEach(q -> {
            q.setRightAnswer("");
        });
        return questions;
    }
}
