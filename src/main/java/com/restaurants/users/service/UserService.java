package com.restaurants.users.service;

import com.restaurants.users.Entity.UserEntity;
import com.restaurants.users.dto.UserDto;
import com.restaurants.users.models.ResponseUsersModel;

import java.util.List;

public interface UserService {
UserDto createUser(UserDto userDetails);
List<ResponseUsersModel> getAllUsers();

}
