package com.onepage.server.domain.user.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignupRequest {
    private String email;
    private String password;
    private String name;
}
