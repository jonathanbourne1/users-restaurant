package com.restaurants.users.models;

import com.restaurants.users.Entity.RoleEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class CreateUserRequestModel  {
    @NotNull(message = "first name cannot be null")
    private String firstName;
    @NotNull(message = "last name cannot be null")
    private String lastName;
    @NotNull(message = "password cannot be null")
    @Size(min = 7, max = 16,message = "password must have at leat 7 Charactes and max 16 characters")
    private String password;
    @Email
    @NotNull(message = "e-mail cannot be null")
    private String email;
    @NotNull(message = "username cannot be null")
    private String username;


    //GETTERS AND SETTERS


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
