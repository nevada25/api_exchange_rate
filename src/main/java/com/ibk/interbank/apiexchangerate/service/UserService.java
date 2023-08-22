package com.ibk.interbank.apiexchangerate.service;


import com.ibk.interbank.apiexchangerate.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> all();
    User byId(String userId);



}
