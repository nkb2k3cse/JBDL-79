package com.example.L14_minor_project_01.dto;

public class CreateCompanyRequestDto {
    private String name;
    private UserDto primaryUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(UserDto primaryUser) {
        this.primaryUser = primaryUser;
    }


}
