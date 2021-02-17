package com.example.sociallogindemo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name="users")
public class Users {
    @Id
    @GeneratedValue
    private int userId;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Enumerated(EnumType.STRING)
    @Column
    private AuthProvider authProvider;
}
