package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.exception.QuizNotAvailableException;
import com.shivamvyas.quizapp.model.Question;
import com.shivamvyas.quizapp.model.QuestionClient;
import com.shivamvyas.quizapp.model.Quiz;
import com.shivamvyas.quizapp.repo.IQuestionRepo;
import com.shivamvyas.quizapp.repo.IQuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<QuestionClient> getQuizQuestions(Long id) {
        Optional<Quiz> optional = repo.findById(id);
        if(optional.isPresent()) {
            Quiz quizDb = optional.get();
            List<Question> questionsFromDb = quizDb.getQuestions();
            return getQuestionClients(questionsFromDb);
        }
        throw new QuizNotAvailableException("Quiz with given id is not available. Please try again!");
    }

    private static List<QuestionClient> getQuestionClients(List<Question> questionsFromDb) {
        List<QuestionClient> questionsForUsers = new ArrayList<>();

        for(Question q : questionsFromDb) {
            QuestionClient qc = new QuestionClient();

            qc.setId(q.getId());
            qc.setQuestionTitle(q.getQuestionTitle());
            qc.setOption1(q.getOption1());
            qc.setOption2(q.getOption2());
            qc.setOption3(q.getOption3());
            qc.setOption4(q.getOption4());

            questionsForUsers.add(qc);
        }
        return questionsForUsers;
    }
}
