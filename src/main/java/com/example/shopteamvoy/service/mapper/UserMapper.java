package com.example.shopteamvoy.service.mapper;

import com.example.shopteamvoy.dto.request.UserRequest;
import com.example.shopteamvoy.dto.response.UserResponse;
import com.example.shopteamvoy.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements RequestDtoMapper<User, UserRequest>,
        ResponseDtoMapper<User, UserResponse> {
    @Override
    public User mapToModel(UserRequest dto) {
        User user = new User();
        user.setName(dto.getName());
        return user;
    }

    @Override
    public UserResponse mapToDto(User user) {
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setId(user.getId());
        return response;
    }
}
