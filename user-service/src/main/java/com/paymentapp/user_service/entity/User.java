package com.paymentapp.user_service.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name="app user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;

    private String password;


}
