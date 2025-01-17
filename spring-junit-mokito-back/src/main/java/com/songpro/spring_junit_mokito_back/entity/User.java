package com.songpro.spring_junit_mokito_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "USER_ID", length = 100)
    private String userId;

    @Column(name = "USER_PWD", length = 200)
    private String userPwd;

    @Column(name = "USER_NAME", length = 20)
    private String userName;
}
