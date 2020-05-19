package com.business.proxy.controller;

import com.business.proxy.clients.StorageServiceClient;
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
    private StorageServiceClient storageServiceClient;

    @GetMapping("/getAllQuestions")
    public List<Map<String, String>> getAllQuestions() {
        String test = "TEST";
        System.out.println(test);
        return storageServiceClient.getAllQuestions();
    }
}
