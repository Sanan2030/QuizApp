package com.Matazor.quizApp.Repository;

import com.Matazor.quizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}
