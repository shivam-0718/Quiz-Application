package com.shivamvyas.quizapp.repo;

import com.shivamvyas.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Long> {
}
