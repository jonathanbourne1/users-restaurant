package com.restaurants.users.service;

import com.restaurant.commons.models.entity.User;
import com.restaurants.users.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User findByUsername(String usernamer);
    public User findByEmail(String email);
    public UserDto createUser(UserDto userdetails);
}
