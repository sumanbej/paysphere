package com.paymentapp.user_service.controller;

import com.paymentapp.user_service.dto.UserRequest;
import com.paymentapp.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);

    }


}
