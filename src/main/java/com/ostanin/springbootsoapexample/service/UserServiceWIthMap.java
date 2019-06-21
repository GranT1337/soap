package com.ostanin.springbootsoapexample.service;

import com.ostanin.spring.User;
import com.ostanin.springbootsoapexample.dao.UserJpaDAO;
import com.ostanin.springbootsoapexample.dto.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceWIthMap {

    private static final Map<String, User> users = new HashMap<>();

    @Autowired
    private UserJpaDAO userDAO;

    @PostConstruct
    public void initialize() {



        User peter = new User();
        peter.setName("Peter");
        peter.setEpmId(123);
        peter.setSalary(10000);

        User max = new User();
        max.setName("Max");
        max.setEpmId(124);
        max.setSalary(10);

        User sam = new User();
        sam.setName("Sam");
        sam.setEpmId(1703);
        sam.setSalary(1478);

//        userDAO.save(peter);
//        userDAO.save(max);
//        userDAO.save(sam);
        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(max.getName(), max);

    }

    public UserJPA getUsers(String name) {
        return userDAO.findByName(name);
    }

    public void createUser(User user) {
        users.put(user.getName(), user);
    }

    public void deleteUser(String name){
        users.remove(name);
    }

    public User updateUser(User user) throws RuntimeException{
        if (users.containsKey(user.getName())) {
            users.put(user.getName(), user);
        } else {
            throw new RuntimeException();
        }
        return users.get(user.getName());
    }
}
