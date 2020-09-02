package com.restaurants.users.controller;


import com.restaurant.commons.models.entity.User;
import com.restaurants.users.model.dto.UserDto;
import com.restaurants.users.model.filter.UserModelFilter;
import com.restaurants.users.model.response.UserResponse;
import com.restaurants.users.service.UserService;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private Environment env;

    @PostMapping
    public ResponseEntity<UserResponse> createNewUser(@Valid @RequestBody UserModelFilter usermodel){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (modelMapper==null){
            new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        UserDto userDto= modelMapper.map(usermodel,UserDto.class);
        UserDto user= userService.createUser(userDto);
        if(user==null){
            new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        UserResponse userResponse= modelMapper.map(user,UserResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }


    @GetMapping("/findbyusername")
    public ResponseEntity<User> findUserByUsername(@RequestParam String username){
         User user =userService.findByUsername(username);
        if(user==null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @GetMapping("/findbyemail")
    public ResponseEntity<User> findUserByEmail(@RequestParam String email){
        User user= userService.findByEmail(email);
        if(user==null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }




}
