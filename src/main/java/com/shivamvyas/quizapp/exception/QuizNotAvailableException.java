package com.shivamvyas.quizapp.exception;

public class QuizNotAvailableException extends RuntimeException {
    public QuizNotAvailableException(String message) {
        super(message);
    }
}
