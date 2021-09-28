package com.blogcode.aspect;

import com.blogcode.history.History;
import com.blogcode.history.HistoryRepository;
import com.blogcode.user.User;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class userHistory {

    @Autowired
    private HistoryRepository historyRepository;

    @Pointcut("execution(* com.blogcode.user.UserService.update(*)) && args(user)")
    public void updateUser(User user) {}

    @AfterReturning("updateUser(user)")
    public void saveHistory(User user) {
        historyRepository.save(new History(user.getIdx()));
    }
}
