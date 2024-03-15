package com.renato.shoppingcart.services.impl;

import com.renato.shoppingcart.config.auth.JwtService;
import com.renato.shoppingcart.dtos.request.AuthDTO;
import com.renato.shoppingcart.dtos.request.RefreshTokenRequestDTO;
import com.renato.shoppingcart.dtos.request.RegisterDTO;
import com.renato.shoppingcart.dtos.response.AuthenticationResponse;
import com.renato.shoppingcart.dtos.response.CreateUserResponse;
import com.renato.shoppingcart.entities.User;
import com.renato.shoppingcart.enums.Role;
import com.renato.shoppingcart.mappers.UserMapper;
import com.renato.shoppingcart.repositories.UserRepository;
import com.renato.shoppingcart.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public CreateUserResponse registerAccount(RegisterDTO register) {
        //TODO change exception
        userRepository.findByEmail(register.getEmail()).ifPresent(user -> {
            throw new UsernameNotFoundException("");
        });

        var user = User.builder()
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .firstName(register.getFirstName())
                .lastName(register.getLastName())
                .image(register.getImage())
                .role(Role.USER)
                .build();

        return UserMapper.INSTANCE.userTocreateUserResponse(userRepository.save(user));
    }

    @Override
    public AuthenticationResponse authenticate(AuthDTO auth) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(auth.getEmail(), auth.getPassword())
        );

        var user = findByEmailOrThrow(auth.getEmail());
        return AuthenticationResponse.builder().accessToken(jwtService.generateAccessToken(user))
                .build();
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequestDTO refreshTokenRequest) {
        return null;
    }

    User findByEmailOrThrow(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(""));
    }

}
