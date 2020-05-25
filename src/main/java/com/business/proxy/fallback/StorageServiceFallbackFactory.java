package com.business.proxy.fallback;

import com.business.proxy.clients.FeignStorageServiceClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mmustafin@context-it.ru
 * @created: 19.05.2020
 */

@Component
public class StorageServiceFallbackFactory implements FallbackFactory<FeignStorageServiceClient> {

    @Override
    public FeignStorageServiceClient create(Throwable throwable) {
        return new FeignStorageServiceClient() {
            @Override
            public List<Map<String, Object>> getAllQuestions() {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("code", "ERROR");
                errorResponse.put("cause", throwable.getMessage());
                return Arrays.asList(errorResponse);
            }

            @Override
            public Map<String, Object> getQuestion(String id) {
                return null;
            }

            @Override
            public List<Map<String, Object>> getAllAnswers(String questionId) {
                return null;
            }

            @Override
            public byte[] getMinioFile(String bucket, String path) {
                return null;
            }
        };
    }
}
