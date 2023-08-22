package com.ibk.interbank.apiexchangerate.repository;

import com.ibk.interbank.apiexchangerate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {


    @Query(nativeQuery = true, value = "SELECT * FROM users where username=:username")
    User finByUsername(String username);
}
