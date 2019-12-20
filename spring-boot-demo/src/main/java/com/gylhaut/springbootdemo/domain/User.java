package com.gylhaut.springbootdemo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="user")
@Entity
//用这个注解才能实现动态更新（update_time的更新）
@Data //lombok
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +

                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
