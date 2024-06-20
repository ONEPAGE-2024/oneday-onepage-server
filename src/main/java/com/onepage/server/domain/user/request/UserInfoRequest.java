package com.onepage.server.domain.user.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserInfoRequest {
    private String email;
    private String name;
}
