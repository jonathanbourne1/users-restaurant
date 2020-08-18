package com.restaurants.users.service;

import com.restaurants.users.Entity.RoleEntity;
import com.restaurants.users.Entity.UserEntity;
import com.restaurants.users.data.UserRepository;
import com.restaurants.users.dto.UserDto;
import com.restaurants.users.models.ResponseUsersModel;
import com.restaurants.users.models.RoleModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    List<RoleEntity> role;
    private Object List;

    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder= bCryptPasswordEncoder;
            }



    @Override
    public UserDto createUser(UserDto userDetails) {
        List<RoleEntity> role = new ArrayList<RoleEntity>();
        Long roleId = Long.parseLong("2");
        RoleEntity roleModel = new RoleEntity(roleId,"USER");
        role.add(roleModel);
        userDetails.setRole(role);

        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        userDetails.setEnabled(true);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=modelMapper.map(userDetails,UserEntity.class);
        userRepository.save(userEntity);
        UserDto userCreated=modelMapper.map(userDetails,UserDto.class);
        return userCreated;
    }

    @Override
    public List<ResponseUsersModel> getAllUsers() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        List<ResponseUsersModel> userReponse = users.stream().map(user -> modelMapper.map(user,ResponseUsersModel.class) ).collect(Collectors.toList());
        return userReponse;
    }
}
