package com.paymentapp.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogInResponse {
    private String token;
    private String email;
    private String role;
    private Long userId;
}
