package com.shivamvyas.quizapp.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(String message) {
        super(message);
    }
}
