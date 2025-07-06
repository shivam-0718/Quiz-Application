package com.shivamvyas.quizapp.rest;

import com.shivamvyas.quizapp.model.Question;
import com.shivamvyas.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService service;

    @Autowired
    public void setService(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = service.getQuestions();
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<String>> showCategories() {
        List<String> categories = service.showCategoriesList();
        return new ResponseEntity<List<String>>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("category") String category) {
        List<Question> questions = service.getQuestionsByCategory(category);
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @PostMapping("/add-question")
    public ResponseEntity<String> addAQuestion(@RequestBody Question question) {
        String response = service.addQuestion(question);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-question/{id}")
    public ResponseEntity<String> updateAQuestion(@PathVariable("id")Long id, @RequestBody Question question) {
        String response = service.updateQuestion(id, question);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


}
