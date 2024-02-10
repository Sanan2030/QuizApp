package com.Matazor.quizApp.Controller;
import com.Matazor.quizApp.Model.QuestionWrapper;
import com.Matazor.quizApp.Model.Response;
import com.Matazor.quizApp.Service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/id")
   public ResponseEntity<List<QuestionWrapper>>GetQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestion(id);
    }
@PostMapping("submit{id}")
public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@PathVariable List<Response>responses) {
        return quizService.calculateResult(id,responses);


}
}