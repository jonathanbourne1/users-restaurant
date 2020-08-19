package com.restaurants.users.service;

import com.restaurants.users.Entity.Response;
import com.restaurants.users.Entity.RoleEntity;
import com.restaurants.users.Entity.UserEntity;
import com.restaurants.users.data.UserRepository;
import com.restaurants.users.dto.UserDto;
import com.restaurants.users.models.RequestLogin;
import com.restaurants.users.models.ResponseUsersModel;
import com.restaurants.users.models.RoleModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder= bCryptPasswordEncoder;
            }


            //BAD REQUEST WITH MESSAGE
            private ResponseEntity badRequestMessage(String message){
        return new ResponseEntity( new Response(HttpStatus.BAD_REQUEST,message),HttpStatus.BAD_REQUEST);
            }


    //BAD REQUEST
    ResponseEntity badRequest = new ResponseEntity<>(
            new Response(
                    HttpStatus.BAD_REQUEST, "Ha ocurrido un error"), HttpStatus.BAD_REQUEST);


    //NOT FOUND WITH OBJECT AND ID
    private ResponseEntity notFoundObject(String objeto,Long id){
        return new ResponseEntity<>(
                new Response(
                        HttpStatus.NOT_FOUND,"No se encontró el " + objeto + " con el id: "+ id+"" ), HttpStatus.NOT_FOUND);
    }


    private ResponseEntity objectsnotFound(String objeto){
        return new ResponseEntity<>(
                new Response(
                        HttpStatus.NOT_FOUND,"No se encontró ningun usuario "), HttpStatus.NOT_FOUND);
    }


    private ResponseEntity notFoundemail(String objeto,String email){
        return new ResponseEntity<>(
                new Response(
                        HttpStatus.NOT_FOUND,"No se encontró el " + objeto + " con : "+ email+"" ), HttpStatus.NOT_FOUND);
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
    public ResponseEntity <List<ResponseUsersModel>> getAllUsers() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try{
            List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
            if(users==null){
                return objectsnotFound("users");
            }else{
                List<ResponseUsersModel> userReponse = users.stream().map(user -> modelMapper.map(user,ResponseUsersModel.class) ).collect(Collectors.toList());
                return new ResponseEntity(userReponse,HttpStatus.OK);
            }
        }catch (Exception e){
            return badRequestMessage(e.getMessage());
        }
    }

    @Override
    public ResponseEntity findByEmail(RequestLogin requestLogin) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try{
            UserEntity userEntity=userRepository.findByEmail(requestLogin.getEmail());

            if(userEntity==null){
                return notFoundemail("user", requestLogin.getEmail());
            }else{
                return new ResponseEntity(userEntity,HttpStatus.OK);
            }
        } catch (Exception e){
            return badRequest;
        }
    }

    @Override
    public ResponseEntity findByUsername(String username) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try{
            UserEntity userEntity =userRepository.findByUsername(username);
            if(userEntity==null){
                return objectsnotFound("user");
            }else{
                return new ResponseEntity(userEntity,HttpStatus.OK);
            }
        }catch (Exception e){
            return badRequestMessage(e.getMessage());
        }
    }
}
