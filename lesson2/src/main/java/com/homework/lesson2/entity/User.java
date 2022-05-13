package com.homework.lesson2.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    private String firstName;

    private String lastName;

    private String phone;

}
