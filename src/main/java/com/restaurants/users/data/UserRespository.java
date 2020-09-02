package com.restaurants.users.data;

import com.restaurant.commons.models.entity.*;
import com.restaurants.users.model.dto.UserDto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRespository extends PagingAndSortingRepository<User, Long> {


    User findByUsername(String username);

    User findByEmail( String email);
}
