package com.shivamvyas.quizapp.service;

import com.shivamvyas.quizapp.exception.QuestionNotFoundException;
import com.shivamvyas.quizapp.exception.QuizNotAvailableException;
import com.shivamvyas.quizapp.model.Question;
import com.shivamvyas.quizapp.model.QuestionClient;
import com.shivamvyas.quizapp.model.Quiz;
import com.shivamvyas.quizapp.model.Response;
import com.shivamvyas.quizapp.repo.IQuestionRepo;
import com.shivamvyas.quizapp.repo.IQuizRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@Service
@Slf4j
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

    @Override
    public String calculateResult(Long id, List<Response> responses) {
        Optional<Quiz> optional = repo.findById(id);
        if(optional.isPresent()) {
            //get questions from quiz
            Quiz quiz = optional.get();
            List<Question> questionsFromQuiz = quiz.getQuestions();

            int rightAnswers = 0;
            int i = 0;
            int totalQuestions = questionsFromQuiz.size();

            // Create a map of question ID to correct answer
            Map<Long, String> questionAnswerMap = new HashMap<>();
            for (Question q : questionsFromQuiz) {
                questionAnswerMap.put(q.getId(), q.getRightAnswer());
            }

            //checking each response against correct answer
            for(Response res : responses) {
                Long questionId = res.getId();
                String userAnswer = res.getResponse();

                //Verifying if the questionID exists in questionAnswerMap
                if(!questionAnswerMap.containsKey(questionId)) {
                    throw new QuestionNotFoundException("Invalid Question ID in the Quiz: " + questionId);
                }

                String correctAnswer = questionAnswerMap.get(questionId);

                //Checking if user entered a null answer of if correct answer is null
                if(userAnswer == null) {
                    throw new IllegalArgumentException("User Answer cannot be null");
                }

                if(correctAnswer == null) {
                    throw new IllegalArgumentException("Correct Answer cannot be null");
                }

                //Checking if responses entered by user is matching with the correct answers.
                if(userAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
                    rightAnswers++;
                }
            }
            return "You have earned score of " + rightAnswers + " out of " + totalQuestions;
        }
        throw new QuizNotAvailableException("There is some issue, please try again.");
    }
}
