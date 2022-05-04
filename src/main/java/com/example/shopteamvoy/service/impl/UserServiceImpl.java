package com.example.shopteamvoy.service.impl;

import com.example.shopteamvoy.dao.UserDao;
import com.example.shopteamvoy.model.User;
import com.example.shopteamvoy.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User add(User user) {
        return dao.save(user);
    }

    @Override
    public User get(Long id) {
        return dao.getById(id);
    }

    @Override
    public User update(User user) {
        return dao.save(user);
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }
}
