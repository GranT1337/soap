package com.ostanin.springbootsoapexample.dto;

import com.ostanin.spring.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USERS")
@NoArgsConstructor
public class UserJPA extends User {
    @Column(name = "name")
    protected String name;
    @Column(name = "epmId")
    @Id
    protected int epmId;
    @Column(name = "salary")
    protected double salary;

    public UserJPA(User user) {
        this.name = user.getName();
        this.epmId = user.getEpmId();
        this.salary = user.getSalary();
    }
}
