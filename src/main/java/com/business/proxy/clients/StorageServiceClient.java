package com.business.proxy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author: mmustafin@context-it.ru
 * @created: 18.05.2020
 */
@FeignClient(name = "storage")
public interface StorageServiceClient {

    @GetMapping("/question/getAllQuestions")
    public List<Map<String, String>> getAllQuestions();
}
