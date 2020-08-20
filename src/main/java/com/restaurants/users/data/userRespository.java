package com.restaurants.users.data;

import com.restaurants.users.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path = "users")
public interface userRespository extends PagingAndSortingRepository<User, Long> {

    @Query("select  u from User u where u.username=?1")
    @RestResource(path = "username")
    User findByUsername(String username);
}
