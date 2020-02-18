package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

     User getFirstByGoogleId(String googleI);

     Boolean existsByGoogleId(String googleId);
}
