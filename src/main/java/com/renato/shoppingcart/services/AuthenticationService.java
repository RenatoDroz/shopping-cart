package com.renato.shoppingcart.services;

import com.renato.shoppingcart.dtos.request.AuthDTO;
import com.renato.shoppingcart.dtos.request.RefreshTokenRequestDTO;
import com.renato.shoppingcart.dtos.request.RegisterDTO;
import com.renato.shoppingcart.dtos.response.AuthenticationResponse;
import com.renato.shoppingcart.dtos.response.CreateUserResponse;

public interface AuthenticationService {
    CreateUserResponse registerAccount(RegisterDTO register);
    AuthenticationResponse authenticate(AuthDTO auth);

    AuthenticationResponse refreshToken(RefreshTokenRequestDTO refreshTokenRequest);
}
