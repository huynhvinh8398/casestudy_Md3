package com.cg.service;

import com.cg.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService extends IGeneralService<User>{
    User findById(long userId);
    List<User> findAllUser();

    public boolean existsByEmail(String email);
    public boolean existsByPhone(String phone);
//    Map<String, String> doCreate(User user);

}
