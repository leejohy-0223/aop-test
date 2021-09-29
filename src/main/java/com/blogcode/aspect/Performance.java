package com.blogcode.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Performance {

    @Pointcut("execution(* com.blogcode.board.BoardService.*(..))")
    public void getBoards() {}

    @Pointcut("execution(* com.blogcode.user.UserService.*(..))")
    public void getUsers() {}

//    @Around("getBoards() || getUsers()")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("수행 시간 : " + (end - start));
        } catch (Throwable throwable) {
            System.out.println("exception !!");
        }
        return result;
    }
}
