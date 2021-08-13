package com.citi.training.SpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="person")
public class Person implements Serializable {
    //TODO are we using email as id?
    @Id
    @Column(name = "email") private String email;
    @Column(name = "name") private String name;
}
