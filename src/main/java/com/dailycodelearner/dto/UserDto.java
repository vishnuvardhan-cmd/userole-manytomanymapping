package com.dailycodelearner.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String userName;
    private String userCreatedBy;
    private LocalDateTime userCreatedDate;
    private String userModifiedBy;
    private LocalDateTime userModifiedDate;
    private List<String> rolenames;
}
