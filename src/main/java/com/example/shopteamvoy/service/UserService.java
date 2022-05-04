package com.example.shopteamvoy.service;

import com.example.shopteamvoy.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);
}
