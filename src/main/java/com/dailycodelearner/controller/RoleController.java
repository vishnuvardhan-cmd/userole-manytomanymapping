package com.dailycodelearner.controller;

import com.dailycodelearner.dto.RoleDto;
import com.dailycodelearner.entity.Role;
import com.dailycodelearner.service.RoleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/roles")
    public ResponseEntity<RoleDto> addRole(@RequestBody RoleDto roleDto){
        RoleDto dto = roleService.addRole(roleDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Long id){
        RoleDto dto = roleService.getRoleById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<RoleDto> updateRoleById(@PathVariable("id")Long id,@RequestBody RoleDto roleDto){
        RoleDto roleDto1 = roleService.updateRoleById(id, roleDto);
        return ResponseEntity.ok(roleDto1);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable("id") Long id){
        String s = roleService.deleteById(id);
        return ResponseEntity.ok(s);
    }
}
