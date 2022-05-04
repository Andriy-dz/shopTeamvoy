package com.example.shopteamvoy.dao;

import com.example.shopteamvoy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
