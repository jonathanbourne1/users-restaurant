package com.restaurants.users.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false, length = 20)
    private String EncryptedPassword;
    @Column(nullable = false)
    private String userId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_to_roles" , joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns =
    @JoinColumn(name="role_id"),uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})})
    private List<RoleEntity> role;


//GETTERS AND SETTERS


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEncryptedPassword() {
        return EncryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        EncryptedPassword = encryptedPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
