package com.gulbagomedovich.authenticationservice.service;

import com.gulbagomedovich.authenticationservice.dto.RegistrationRequest;
import com.gulbagomedovich.authenticationservice.dto.RegistrationResponse;

public interface RegistrationService {
    RegistrationResponse signup(RegistrationRequest request);
}
