package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.model.Question;
import com.shivamvyas.quizapp.model.Quiz;
import com.shivamvyas.quizapp.repo.IQuestionRepo;
import com.shivamvyas.quizapp.repo.IQuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizService implements IQuizService{

    @Autowired
    private IQuizRepo repo;

    @Autowired
    private IQuestionRepo questionRepo;

    @Override
    public String createQuiz(String category, int numOfQues, String title) {
        //fetching random questions from DB as per category
        List<Question> quizQuestions = questionRepo.findRandomQuesByCategory(category, numOfQues);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(quizQuestions);
        repo.save(quiz);

        return "Quiz has been created!";
    }
}
