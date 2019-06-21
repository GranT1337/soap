package com.ostanin.springbootsoapexample.dao;

import com.ostanin.spring.User;
import com.ostanin.springbootsoapexample.dto.UserJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaDAO extends CrudRepository<UserJPA, Integer> {

    UserJPA findByName(String name);

    void deleteByName(String name);

}
