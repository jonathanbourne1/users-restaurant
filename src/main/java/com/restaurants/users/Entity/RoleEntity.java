package com.restaurants.users.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class RoleEntity implements Serializable {

    public RoleEntity() {

    }
    public RoleEntity(Long id, String userRole) {
        this.id = id;
        this.userRole = userRole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userRole;


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
