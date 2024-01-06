package com.dailycodelearner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "AppUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userCreatedBy;
    private LocalDateTime userCreatedDate;
    @ColumnDefault("null")
    private String userModifiedBy;
    @ColumnDefault("null")
    private LocalDateTime userModifiedDate;
    @ManyToMany( cascade = {CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "UserId", referencedColumnName = "userId")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "RoleId", referencedColumnName = "roleId")
            })
    private Set<Role> roles;

    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    public void removeRoles(){
        for(Role role:new HashSet<>(roles)){
            removeRole(role);
        }
    }
}

