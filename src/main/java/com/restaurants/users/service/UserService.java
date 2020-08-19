package com.restaurants.users.service;


import com.restaurants.users.dto.UserDto;
import com.restaurants.users.models.RequestLogin;
import com.restaurants.users.models.ResponseUsersModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
UserDto createUser(UserDto userDetails);
ResponseEntity<List<ResponseUsersModel>> getAllUsers();
ResponseEntity findByEmail(RequestLogin requestLogin);
ResponseEntity findByUsername(String username);


}
