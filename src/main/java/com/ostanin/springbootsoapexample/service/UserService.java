package com.ostanin.springbootsoapexample.service;

import com.ostanin.spring.User;
import com.ostanin.springbootsoapexample.dao.UserJpaDAO;
import com.ostanin.springbootsoapexample.dto.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    //private static final Map<String, User> users = new HashMap<>();

    @Autowired
    private UserJpaDAO userJpaDAO;


    @PostConstruct
    public void initialize() {
        UserJPA peter = new UserJPA();
        peter.setName("Peter");
        peter.setEpmId(123);
        peter.setSalary(10000);

        UserJPA max = new UserJPA();
        max.setName("Max");
        max.setEpmId(124);
        max.setSalary(10);

        UserJPA sam = new UserJPA();
        sam.setName("Sam");
        sam.setEpmId(1703);
        sam.setSalary(1478);

        userJpaDAO.save(peter);
        userJpaDAO.save(max);
        userJpaDAO.save(sam);

    }

    //@Cacheable(value = "users")
    public User getUsers(String name) {
        UserJPA userJPA = userJpaDAO.findByName(name);

        User user = new User();
        user.setEpmId(userJPA.getEpmId());
        user.setName(userJPA.getName());
        user.setSalary(userJPA.getSalary());
        return user;
    }


    public void createUser(User user) {
        UserJPA userJPA = new UserJPA(user);
        userJpaDAO.save(userJPA);
    }


    public void deleteUser(int id){
        userJpaDAO.deleteById(id);
    }


   // @CachePut(value = "users")
    public User updateUser(User user) throws RuntimeException{
        UserJPA userJPA = new UserJPA(user);
        if (userJpaDAO.existsById(userJPA.getEpmId())) {
            return userJpaDAO.save(userJPA);
        }
        return null;
    }
}
