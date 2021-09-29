package com.blogcode.user;

import com.blogcode.SuperPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();

    void update(User user) throws Exception;

    void update2(User user, Long id) throws Exception;
}
