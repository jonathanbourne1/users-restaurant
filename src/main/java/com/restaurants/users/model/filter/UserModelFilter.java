package com.restaurants.users.model.filter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModelFilter {

    @NotNull(message = "first name cannot be null")
    @Size(min = 2, message = "first name must be at least 2 characters")
    private  String firstName;
    @NotNull(message = "lastname cannot be null")
    @Size(min = 2, message = "first name must be at least 2 characters")
    private String lastName;
    @NotNull(message = "email cannot be null")
    @Email
    private String email;
    @NotNull(message = "password cannot be null")
    @Size(message = "password must be at least 8 characters", min = 8)
    private String password;

    //getters and setters


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
