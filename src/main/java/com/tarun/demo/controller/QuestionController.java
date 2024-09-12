package com.tarun.demo.controller;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tarun.demo.service.QuestionService;
import java.util.List;

@RestController
@RequestMapping("question")

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<com.tarun.demo.model.Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<com.tarun.demo.model.Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody com.tarun.demo.model.Question question) {
        return questionService.addQuestion(question);
    }
}
