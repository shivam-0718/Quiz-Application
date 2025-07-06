package com.shivamvyas.quizapp.repo;

import com.shivamvyas.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Long> {

    //show categories first
    @Query("SELECT DISTINCT q.category FROM Question q")
    List<String> showCategories();

    //show questions by category
    List<Question> findByCategory(String category);

    //getting random questions by category as per specific numbers
    @Query(value = "SELECT * FROM Question q WHERE q.category= :category ORDER BY RAND() LIMIT :num", nativeQuery = true)
    List<Question> findRandomQuesByCategory(@Param("category") String category, @Param("num") int num);

}
