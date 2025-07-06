package com.shivamvyas.quizapp.advice;

import com.shivamvyas.quizapp.exception.QuizNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class QuizControllerAdvice {
    @ExceptionHandler(QuizNotAvailableException.class)
    public ResponseEntity<ErrorDetails> handleQuizException(QuizNotAvailableException qna) {
        ErrorDetails error = new ErrorDetails(qna.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e) {
        ErrorDetails error = new ErrorDetails(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
