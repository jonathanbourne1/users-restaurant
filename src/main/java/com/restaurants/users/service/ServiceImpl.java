package com.restaurants.users.service;

import com.restaurant.commons.models.entity.Role;
import com.restaurant.commons.models.entity.User;
import com.restaurants.users.data.UserRespository;
import com.restaurants.users.model.dto.UserDto;
import com.restaurants.users.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceImpl implements UserService {

    @Autowired
    UserRespository userRespository;

    @Override
    public User findByUsername(String usernamer) {
        return  userRespository.findByUsername(usernamer);
    }

    @Override
    public User findByEmail(String email) {
        return userRespository.findByEmail(email);
    }

    @Override
    public UserDto createUser(UserDto userdetails) {
        //modelmapper
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        //
        userdetails.setUserId(UUID.randomUUID().toString());
        userdetails.setAccountNonExpired(true);
        userdetails.setCredentialsNonExpired(true);
        userdetails.setEnabled(true);
        userdetails.setAccountNonLocked(true);
        userdetails.setEncyptedPassword("test");
        userdetails.setUsername(userdetails.getEmail());
        //ADDING ROLE AS USER
        List<Role> role = new ArrayList<Role>();
        Long roleIdOfUser = Long.parseLong("2");
        Role roleModel = new Role();
        roleModel.setId(roleIdOfUser);
        roleModel.setRole("USER_ROLE");
        role.add(roleModel);
        userdetails.setRole(role);
        //
        User user= modelMapper.map(userdetails,User.class);
       User userDetails=userRespository.save(user);
       UserDto userDto = modelMapper.map(userDetails,UserDto.class);
        return userDto;
    }
}
