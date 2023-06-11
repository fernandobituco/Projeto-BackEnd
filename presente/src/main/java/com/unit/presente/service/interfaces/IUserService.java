package com.unit.presente.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.unit.presente.model.VO.UserVO;
import com.unit.presente.model.entity.User;

public interface IUserService {
    List<User> findAll(); 

    User create(UserVO user);

    void update(UserVO user, UUID id) throws Exception;

    void delete(UUID id);
}
