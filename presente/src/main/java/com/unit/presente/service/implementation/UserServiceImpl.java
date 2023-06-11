package com.unit.presente.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.unit.presente.model.VO.UserVO;
import com.unit.presente.model.entity.User;
import com.unit.presente.repository.UserRepository;
import com.unit.presente.service.interfaces.IUserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User create(UserVO user) {
        User newUser = new User(user);
        userRepository.save(newUser);
        return newUser;
    }

    @Transactional
    public void update(UserVO user, UUID id) throws Exception {
        Optional<User> oldUser = userRepository.findById(id);
        if (oldUser.isEmpty()) {
            throw new Exception("User not found");
        }
        User userUpdate = oldUser.get();
        userUpdate.setCpf(user.cpf);
        userUpdate.setEmail(user.email);
        userUpdate.setName(user.name);
        userUpdate.setPassword(user.password);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
