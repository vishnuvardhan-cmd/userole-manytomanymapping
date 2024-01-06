package com.dailycodelearner.service;

import com.dailycodelearner.dto.RoleDto;
import com.dailycodelearner.entity.Role;
import com.dailycodelearner.entity.User;
import com.dailycodelearner.repository.RoleRepository;
import com.dailycodelearner.repository.UserRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleRepository roleRepository;

    @Resource
    UserRepository userRepository;


    @Transactional
    @Override
    public RoleDto addRole(RoleDto roleDto) {
        Role role =new Role();
        mapDtoToEntity(role,roleDto);
        Role save = roleRepository.save(role);
        return mapEntityToDto(save);
    }




    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> all = roleRepository.findAll();
        List<RoleDto> roles=new ArrayList<>();
        all.stream().forEach(role->{
           roles.add(mapEntityToDto(role));
        });
        return roles;
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            RoleDto roleDto = mapEntityToDto(role.get());
            return roleDto;
        }
        RoleDto roledto=new RoleDto();
        roledto.setName("We don't have any Role with this id : "+5);
        return roledto;
    }

    @Transactional
    @Override
    public RoleDto updateRoleById(Long id, RoleDto roleDto) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            mapDtoToEntity(role.get(),roleDto);
            return mapEntityToDto(role.get());
        }
        RoleDto roledto=new RoleDto();
        roledto.setName("We don't have any Role with this id : "+id);
        return roledto;
    }

    @Transactional
    @Override
    public String deleteById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            role.get().removeUsers();
            roleRepository.delete(role.get());
            return "deleted role successfully with the given Id : "+id;
        }
        return "We don't have any Role with this id : "+id;
    }

    private void mapDtoToEntity(Role role, RoleDto roleDto) {
        role.setRoleName(roleDto.getName());
        if(null==role.getUsers()){
            role.setUsers(new HashSet<>());
        }
        roleDto.getUserNames().stream().forEach(username->{
            User userName = userRepository.findByUserName(username);
            if(userName==null){
                userName=new User();
                userName.setRoles(new HashSet<>());
                userName.setUserCreatedBy("AppExpansionTeam@unisys.com");
                userName.setUserCreatedDate(LocalDateTime.now());
            }
            userName.setUserName(username);
            role.addUser(userName);
        });
    }

    private RoleDto mapEntityToDto(Role role) {
        RoleDto roleDto=new RoleDto();
        roleDto.setId(role.getRoleId());
        roleDto.setName(role.getRoleName());
        roleDto.setUserNames(role.getUsers().stream().map(User::getUserName).collect(Collectors.toList()));
        return roleDto;
    }
}
