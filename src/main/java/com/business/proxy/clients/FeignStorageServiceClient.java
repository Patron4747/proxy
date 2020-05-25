package com.business.proxy.clients;

import com.business.proxy.config.FeignConfiguration;
import com.business.proxy.fallback.StorageServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author: mmustafin@context-it.ru
 * @created: 18.05.2020
 */
@FeignClient(name = "storage",
        configuration = FeignConfiguration.class,
        fallbackFactory = StorageServiceFallbackFactory.class)
public interface FeignStorageServiceClient {

    @GetMapping("/question/getAllQuestions")
    public List<Map<String, Object>> getAllQuestions();

    @GetMapping("/question/getQuestion")
    public Map<String, Object> getQuestion(@RequestParam("id") String id);

    @GetMapping("/question/{questionId}/getAnswersTree")
    public List<Map<String, Object>> getAllAnswers(@PathVariable("questionId") String questionId);

    @GetMapping(value = "/minio/getFile")
    public byte[] getMinioFile(@RequestParam(name = "bucket") String bucket,
                               @RequestParam(name = "path") String path);
}
