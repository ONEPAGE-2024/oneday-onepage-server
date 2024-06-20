package com.onepage.server.domain.user.service;

import com.onepage.server.domain.user.request.SignupRequest;
import com.onepage.server.global.exception.BusinessException;

public interface UserService {
    void registerUser(SignupRequest signupRequest) throws BusinessException;
}