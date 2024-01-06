package com.dailycodelearner.service;

import com.dailycodelearner.dto.UserDto;
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
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Resource
    RoleRepository roleRepository;

    @Transactional
    @Override
    public UserDto addUser(UserDto userDto) {
        User user=new User();
        mapDtoToEntity(user,userDto);
        User savedUser=userRepository.save(user);
        return mapEntityToDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos=new ArrayList<>();
        userRepository.findAll().stream().forEach(user->{
            userDtos.add(mapEntityToDto(user));
        });
        return userDtos;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            UserDto userDto = mapEntityToDto(byId.get());
            return userDto;
        }
        UserDto userDto=new UserDto();
        userDto.setUserName("No user exsist with the given Id : "+id);
        return userDto;
    }

    @Transactional
    @Override
    public UserDto updateUserById(Long id, UserDto userDto) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            mapDtoToEntity(byId.get(),userDto);
            return mapEntityToDto(byId.get());
        }
        UserDto userDto1=new UserDto();
        userDto.setUserName("No user exsist with the given Id : "+id);
        return userDto1;
    }

    @Transactional
    @Override
    public String deleteUserById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            byId.get().removeRoles();
            userRepository.delete(byId.get());
            return "User with given id is deleted successfully";
        }
        return "No User Exsists with the given Id : "+id+" to delete";
    }

    private void mapDtoToEntity(User user, UserDto userDto) {
        user.setUserName(userDto.getUserName());
        user.setUserCreatedBy(userDto.getUserCreatedBy());
        if(userDto.getUserCreatedDate()==null){
        user.setUserCreatedDate(LocalDateTime.now());
        }
        user.setUserCreatedDate(userDto.getUserCreatedDate());
        user.setUserModifiedBy(userDto.getUserModifiedBy());
        user.setUserModifiedDate(userDto.getUserModifiedDate());
        if(userDto.getUserCreatedDate()!=null){
            user.setUserModifiedDate(LocalDateTime.now());
        }

        if(null==user.getRoles()){
            user.setRoles(new HashSet<>());
        }
        userDto.getRolenames().stream().forEach(userdto->{
            Role role = roleRepository.findByRoleName(userdto);
            if(null==role){
                role=new Role();
                role.setUsers(new HashSet<>());
            }
            role.setRoleName(userdto);
            user.addRole(role);
        });
    }

    private UserDto mapEntityToDto(User savedUser) {
        UserDto userDto=new UserDto();
        userDto.setId(savedUser.getUserId());
        userDto.setUserName(savedUser.getUserName());
        userDto.setUserCreatedBy(savedUser.getUserCreatedBy());
        userDto.setUserCreatedDate(savedUser.getUserCreatedDate());
        userDto.setUserModifiedBy(savedUser.getUserModifiedBy());
        userDto.setUserModifiedDate(savedUser.getUserModifiedDate());
        userDto.setRolenames(savedUser.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()));
        return userDto;
    }

}
