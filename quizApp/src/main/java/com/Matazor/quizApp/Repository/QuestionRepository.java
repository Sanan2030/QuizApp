package com.Matazor.quizApp.Repository;

import com.Matazor.quizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
  List<Question> findByCategory (String category);
  @Query(value = "SELECT * FROM question q where q.category=:category order by RANDOM() LIMIT :numQ",nativeQuery = true)
  List<Question> findRandomQuestionByCategory(String category, int numQ);
}
