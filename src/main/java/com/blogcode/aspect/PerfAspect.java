package com.blogcode.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfAspect {

//    @Around("@annotation(PerfLogging))") // PerfLogging이 붙은 클래스에 적용

//    @Around("execution(* com.blogcode.event.SimpleEventService.*(..))") // SimpleEventService 아래의 0개 이상 인자를 가진 메서드에 적용, 즉 모든 메서드 적용

//    @Around("execution(* com.blogcode.event.SimpleEventService.createEvent())")
    @Around("@annotation(PerfLogging)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    @Before("bean(simpleEventService)") // simpleEventService로 등록된 빈이 실행되기 전 호출
    public void hello() {
        System.out.println("hello");
    }

}
