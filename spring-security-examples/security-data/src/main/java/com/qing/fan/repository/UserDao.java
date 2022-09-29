package com.qing.fan.repository;

import com.qing.fan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}