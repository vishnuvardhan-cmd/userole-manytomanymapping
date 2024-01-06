package com.dailycodelearner.repository;

import com.dailycodelearner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUserName(String name);
}
