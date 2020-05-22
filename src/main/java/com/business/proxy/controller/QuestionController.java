package com.business.proxy.controller;

import com.business.proxy.clients.FeignStorageServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
