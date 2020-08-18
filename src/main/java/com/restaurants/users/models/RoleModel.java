package com.restaurants.users.models;


public class RoleModel {

    private Long id;
    private String userRole;
    ///CONSTRUCTOR

    public RoleModel(Long id, String userRole) {
        this.id = id;
        this.userRole = userRole;
    }
//GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
