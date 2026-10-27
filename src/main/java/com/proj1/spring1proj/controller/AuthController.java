package com.proj1.spring1proj.controller;

import com.proj1.spring1proj.dto.LoginResponse;
import com.proj1.spring1proj.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService){
        this.authenticationManager= authenticationManager;
        this.jwtService= jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestParam String username, @RequestParam String password){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        String role = authentication.getAuthorities()
                .stream()
                .map(authority -> authority.getAuthority())
                .filter(authority -> authority.startsWith("ROLE_"))
                .map(authority -> authority.substring(5))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Authenticated User has no role"));
        String token = jwtService.generateToken(authentication.getName());

        return new LoginResponse(token, role);
    }
}
