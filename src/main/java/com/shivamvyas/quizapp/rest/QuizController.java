package com.shivamvyas.quizapp.rest;

import com.shivamvyas.quizapp.model.QuestionClient;
import com.shivamvyas.quizapp.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private IQuizService service;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numOfQues, @RequestParam String title) {
        String response = service.createQuiz(category, numOfQues, title);
        return new ResponseEntity<String>("This is the page", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionClient>> getQuizQuestions(@PathVariable Long id) {
        List<QuestionClient> questionsToUser = service.getQuizQuestions(id);
        return new ResponseEntity<List<QuestionClient>>(questionsToUser, HttpStatus.OK);
    }
}
