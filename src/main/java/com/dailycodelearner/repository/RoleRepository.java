package com.dailycodelearner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dailycodelearner.entity.Role;
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByRoleName(String name);
}
