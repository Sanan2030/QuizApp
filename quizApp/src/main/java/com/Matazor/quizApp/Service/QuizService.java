package com.Matazor.quizApp.Service;
import com.Matazor.quizApp.Model.Question;
import com.Matazor.quizApp.Model.QuestionWrapper;
import com.Matazor.quizApp.Model.Quiz;
import com.Matazor.quizApp.Model.Response;
import com.Matazor.quizApp.Repository.QuestionRepository;
import com.Matazor.quizApp.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuizService {
@Autowired
    QuestionRepository questionRepository;
@Autowired
    QuizRepository quizRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question>questions=questionRepository.findRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

return new  ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
      Quiz quiz=quizRepository.getById(id);
      List<Question>questionfromDb=quiz.getQuestions();
      List<QuestionWrapper>QuestionforUser=new ArrayList<>();
for (Question q:questionfromDb){
    QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
    QuestionforUser.add(qw);
}        return new ResponseEntity<>(QuestionforUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizRepository.findById(id).get();
        int right=0;
        int i=0;
        List<Question>questions=quiz.getQuestions();
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
                i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
