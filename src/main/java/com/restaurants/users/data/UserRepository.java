package com.restaurants.users.data;

import com.restaurants.users.Entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {


    @Override
    public Optional<UserEntity> findById(Long id);

   public UserEntity findByUsername(String username);

   @Query("SELECT s FROM UserEntity s where s.email=?1")
    public UserEntity findByEmail(String email);

}
