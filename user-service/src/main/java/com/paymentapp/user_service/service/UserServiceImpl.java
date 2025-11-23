package com.paymentapp.user_service.service;

import com.paymentapp.user_service.dto.UserRequest;
import com.paymentapp.user_service.dto.UserResponse;
import com.paymentapp.user_service.entity.User;
import com.paymentapp.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

    private final UserRepository userRepository;


    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
       User userEntity= new User();
       userEntity.setName(userRequest.getName());
       userEntity.setPassword(userRequest.getPassword());
       userEntity.setEmail(userRequest.getEmail());
       userRepository.save(userEntity);
       UserResponse userResponse = UserResponse.builder().
               id(userEntity.getId())
               .name(userEntity.getName())
               .email(userEntity.getEmail()).build();
       return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(Long id) {
        Optional<User> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            User user = userEntity.get();
            UserResponse userResponse = UserResponse.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
