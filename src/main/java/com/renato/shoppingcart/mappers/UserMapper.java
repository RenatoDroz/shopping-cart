package com.renato.shoppingcart.mappers;

import com.renato.shoppingcart.dtos.response.CreateUserResponse;
import com.renato.shoppingcart.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreateUserResponse userTocreateUserResponse(User user);
}
