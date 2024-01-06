package com.dailycodelearner.service;

import com.dailycodelearner.dto.RoleDto;
import com.dailycodelearner.entity.Role;

import java.util.List;

public interface RoleService {

    public RoleDto addRole(RoleDto roleDto);
    public List<RoleDto> getAllRoles();

    public RoleDto getRoleById(Long id);
    public RoleDto updateRoleById(Long id,RoleDto roleDto);

    public String deleteById(Long id);
}
