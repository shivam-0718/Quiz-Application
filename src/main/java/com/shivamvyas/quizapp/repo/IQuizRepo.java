package com.shivamvyas.quizapp.repo;

import com.shivamvyas.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepo extends JpaRepository<Quiz, Long> {
}
