package com.restaurants.users.controller;


import com.restaurants.users.Entity.UserEntity;
import com.restaurants.users.dto.UserDto;
import com.restaurants.users.models.CreateUserRequestModel;
import com.restaurants.users.models.ResponseModel;
import com.restaurants.users.models.ResponseUsersModel;
import com.restaurants.users.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    UserService service;

    @GetMapping("/test")
    public String test(){
        return "works in "+env.getProperty("local.server.port");
    }

    @PostMapping()
    public ResponseEntity<ResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel requestModel ){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto= modelMapper.map(requestModel,UserDto.class);
        UserDto userCreated = service.createUser(userDto);
        ResponseModel response = modelMapper.map(userCreated, ResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<ResponseUsersModel>getAllUsers()
    {
        return service.getAllUsers();
    }
}
