package com.blogcode.aspect;

import com.blogcode.history.History;
import com.blogcode.history.HistoryRepository;
import com.blogcode.user.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
public class userHistory {

    @Autowired
    private HistoryRepository historyRepository;

    // args() : 메서드의 인자가 타겟 명세에 포함된 타입인 경우. 아래의 경우는 하나의 파라미터를 갖고, 그 인자가 user 타입
    // @args() : 메서드의 인자가 타겟 명세에 포함된 어노테이션 타입일 경우,
//    @Pointcut("execution(* com.blogcode.user.UserService.update2(*, *)) && args(user)")
//    public void updateUser(User user) {}
//
//    @AfterReturning("updateUser(user)")
//    public void saveHistory(User user) {
//        historyRepository.save(new History(user.getIdx()));
//    }

//    @Around("execution(* com.blogcode.user.UserService.*(..))")
    @Around("execution(* com.blogcode.user.UserService.update2(..))")
    public Object updateUser2(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            Object[] args = pjp.getArgs();
            if(args.length != 0) {
                historyRepository.save(new History((Long) args[1]));
            }
            result = pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("exception! ");
        }
        return result;
    }
}
