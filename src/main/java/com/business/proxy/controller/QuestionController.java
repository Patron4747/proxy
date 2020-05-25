package com.business.proxy.controller;

import com.business.proxy.clients.FeignStorageServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: mmustafin@context-it.ru
 * @created: 18.05.2020
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private FeignStorageServiceClient feignStorageServiceClient;

    @GetMapping("/getAllQuestions")
    public List<Map<String, Object>> getAllQuestions() {
        return feignStorageServiceClient.getAllQuestions();
    }

    @GetMapping("/getQuestion")
    public Map<String, Object> getQuestion(@RequestParam("id") String id) {
        return feignStorageServiceClient.getQuestion(id);
    }

    @GetMapping("/{questionId}/getAnswersTree")
    public List<Map<String, Object>> getAllAnswers(@PathVariable("questionId") String questionId) {
        return feignStorageServiceClient.getAllAnswers(questionId);
    }
}
