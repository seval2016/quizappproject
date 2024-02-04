package com.senturk.quizapp.controller;

import com.senturk.quizapp.model.QuestionWrapper;
import com.senturk.quizapp.model.Response;
import com.senturk.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {
    // controller for quiz
    @Autowired
    QuizService quizService;

    //http://localhost:8080/quiz/create?category=Java&numOfQuestions=5&title=JQuiz
    @PostMapping("create")
    public ResponseEntity<String>createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
            return quizService.createQuiz(category,numQ,title);
    }

    //http://localhost:8080/quiz/get/1
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
