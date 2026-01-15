package com.paymentapp.user_service.service;

import com.paymentapp.user_service.dto.LogInRequest;
import com.paymentapp.user_service.dto.LogInResponse;
import com.paymentapp.user_service.dto.UserRequest;
import com.paymentapp.user_service.dto.UserResponse;
import com.paymentapp.user_service.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<UserResponse> createUser(UserRequest userRequest);

    ResponseEntity<UserResponse>  getUserById(Long id);
    ResponseEntity<LogInResponse> login(LogInRequest loginRequest);
    List<User> getAllUsers();
}
