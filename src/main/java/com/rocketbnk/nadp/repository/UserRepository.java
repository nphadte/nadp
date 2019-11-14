package com.rocketbnk.nadp.repository;

import com.rocketbnk.nadp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

        public  Optional<User>  findByUserName  (String  username);

        public  Optional<User>  findByFirstName (String  firstname);

        public  Optional<User>  findByLastName  (String  lastname);

        public  Optional<User> findByEmail(String email);

        public  Optional<User> findByhomeAddress(String  homeaddress);

        public  Optional<User> findByhomeAddressLike(String  partialhomeaddress);

        public  Optional<User> findByworkAddress(String  workaddresss);

        public  Optional<User> findByworkAddressLike(String  partialworkaddresss);

        Optional<User> findByUserNameOrEmail(String username, String email);

        List<User> findByIdIn(List<Long> userIds);

        Boolean existsByUserName(String username);

        Boolean existsByEmail(String email);
    }
