package com.lkyi;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfiguration {

//    @Bean
//    public Customizer<HystrixCircuitBreakerFactory> defaultConfig() {
//        return factory -> factory.configure(builder -> builder.commandProperties(HystrixCommandProperties.Setter()
//                .withExecutionTimeoutInMilliseconds(100)
//                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)));
//    }

}
