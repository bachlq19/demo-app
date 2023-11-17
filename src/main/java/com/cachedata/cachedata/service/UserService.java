package com.cachedata.cachedata.service;

import com.cachedata.cachedata.entity.User;
import com.cachedata.cachedata.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void autoCreateData (){
        List<User> users = new ArrayList<>();
        int i = 0;
        while (i < 1000){
            User user = new User();
            user.setName("Number" + i);
            user.setAge(18);
            users.add(user);
            i++;
        }
        userRepository.saveAll(users);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}
