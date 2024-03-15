package com.renato.shoppingcart.controlers;

import com.renato.shoppingcart.dtos.request.AuthDTO;
import com.renato.shoppingcart.dtos.request.RegisterDTO;
import com.renato.shoppingcart.dtos.response.AuthenticationResponse;
import com.renato.shoppingcart.dtos.response.CreateUserResponse;
import com.renato.shoppingcart.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> register (
            @RequestBody RegisterDTO request
    ){
        return ResponseEntity.ok(authenticationService.registerAccount(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody AuthDTO request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<CreateUserResponse> refreshToken (
            @RequestBody RegisterDTO request
    ){
        return ResponseEntity.ok(authenticationService.registerAccount(request));
    }
}
