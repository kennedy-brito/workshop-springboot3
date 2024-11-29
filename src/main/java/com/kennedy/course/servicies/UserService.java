package com.kennedy.course.servicies;

import com.kennedy.course.entities.User;
import org.springframework.stereotype.Service;
import com.kennedy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
