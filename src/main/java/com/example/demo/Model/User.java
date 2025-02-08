package com.example.demo.Model;


import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;

}
