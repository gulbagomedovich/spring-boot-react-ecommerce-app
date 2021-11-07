package com.gulbagomedovich.authenticationservice.controller;

import com.gulbagomedovich.authenticationservice.dto.RegistrationRequest;
import com.gulbagomedovich.authenticationservice.dto.RegistrationResponse;
import com.gulbagomedovich.authenticationservice.repository.UserRepository;
import com.gulbagomedovich.authenticationservice.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<RegistrationResponse> signup(@RequestBody @Valid RegistrationRequest request) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).body(registrationService.signup(request));
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
