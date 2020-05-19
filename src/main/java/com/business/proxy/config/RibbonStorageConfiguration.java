package com.business.proxy.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * @author: mmustafin@context-it.ru
 * @created: 19.05.2020
 */
@RibbonClient(name = "storage")
public class RibbonStorageConfiguration {

    @Bean
    public IRule loadBlancingRule() {
        return new RoundRobinRule();
    }
}
