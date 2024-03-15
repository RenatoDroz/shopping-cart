package com.renato.shoppingcart.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {

    private String email;
    private String firstName;
    private String lastName;
    private String image;
}
