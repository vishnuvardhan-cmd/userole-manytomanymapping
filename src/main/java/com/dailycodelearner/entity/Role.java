package com.dailycodelearner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy ="roles")
    private Set<User> users;
    public void addUser(User user){
        this.users.add(user);
        user.getRoles().add(this);
    }

    public void removeUser(User user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }

    public void removeUsers(){
        for(User user:users){
            removeUser(user);
        }
    }
}
