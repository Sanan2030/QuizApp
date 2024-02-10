package com.Matazor.quizApp.Controller;

import com.Matazor.quizApp.Model.Question;
import com.Matazor.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping
    public ResponseEntity< List<Question>> getAllQuestions() {

        return questionService.getAllQuestions();
    }
    @GetMapping("/Category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable  String category){
        return  questionService.getBycategory(category);

    }

    @PostMapping
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.addQuestion(question).getStatusCode());
    }

}
