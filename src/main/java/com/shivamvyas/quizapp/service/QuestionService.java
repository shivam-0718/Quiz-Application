package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.exception.QuestionNotFoundException;
import com.shivamvyas.quizapp.model.Question;
import com.shivamvyas.quizapp.repo.IQuestionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionRepo repo;

    @Override
    public List<Question> getQuestions() {
        List<Question> allQuestions = repo.findAll();
        allQuestions.forEach(q -> q.setRightAnswer(""));
        return allQuestions;
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

    @Override
    public String addQuestion(Question question) {
        repo.save(question);
        return "Question has been added successfully!";
    }

    public Question getQuestionById(Long id) {
        Optional<Question> optional = repo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new QuestionNotFoundException("Question is not there in the questionnaire. Please try again!");
    }

    public String updateQuestion(Long id, Question question)  {
        Optional<Question> optional = repo.findById(id);
        if(optional.isPresent()) {
            repo.save(question);
            return "Question has been updated successfully";
        }
        throw new QuestionNotFoundException("Question is not there in the questionnaire. Please try again!");
    }

    public String deleteQuestion(Long id) {
        Optional<Question> optional = repo.findById(id);
        if(optional.isPresent()) {
            repo.deleteById(id);
            return "Question has been deleted successfully";
        }
        throw new QuestionNotFoundException("Question is not there in the questionnaire. Please try again!");
    }

}
