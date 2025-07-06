package com.shivamvyas.quizapp.repo;

import com.shivamvyas.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Long> {

    //show categories first
    @Query("SELECT DISTINCT q.category FROM Question q")
    List<String> showCategories();

    //show questions by category
    List<Question> findByCategory(String category);
}
