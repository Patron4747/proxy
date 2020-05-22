package com.business.proxy.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author: mmustafin@context-it.ru
 * @created: 19.05.2020
 */

public class FeignConfiguration {

    @Bean
    public Logger.Level configureLogLevel() {
        return Logger.Level.FULL;
    }

//    @Bean     Таймаут конекшена и ответа!
//    public Request.Options timeoutConfiguration(){
//        return new Request.Options(5000, 30000);
//    }

//    @Bean     Перехватчик запросов!
//    public RequestInterceptor requestLoggingInterceptor() {
//        return new RequestInterceptor() {
//            @Override
//            public void apply(RequestTemplate template) {
//                template.header("testHeader", "testHeaderValue");
//            }
//        };
//    }

//    @Bean     Базовая аутентификация
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password");
//    }

//    @Bean     Повтор запроса в случае неудачи
//    public Retryer retryer() {
//        return new Retryer.Default(1000, 8000, 3);
//    }


}
