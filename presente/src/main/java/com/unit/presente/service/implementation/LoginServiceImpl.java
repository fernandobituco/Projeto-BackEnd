package com.unit.presente.service.implementation;

import org.springframework.stereotype.Service;

import com.unit.presente.model.VO.LoginVO;
import com.unit.presente.model.entity.User;
import com.unit.presente.repository.UserRepository;
import com.unit.presente.service.interfaces.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

    final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void login(LoginVO loginVo) throws Exception {
        User user = userRepository.findByCpf(loginVo.cpf);
        if (!loginVo.password.equals(user.password)) {
            throw new Exception("Cpf ou senha inválidos");
        }
    }
    
}
