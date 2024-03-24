package com.example.feature.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class CloudAspect {

    @Pointcut("execution (* com.example.boot.cloud.FeigClientService.getPosts*())")
    public void fetchPosts() {
    }

    @Before("fetchPosts()")
    public void logBefore(JoinPoint jp) {
        log.info("Gonna call {}", jp.getSignature().getName());
    }
}
