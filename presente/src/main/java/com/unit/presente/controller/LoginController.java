package com.unit.presente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.presente.model.VO.LoginVO;
import com.unit.presente.service.interfaces.ILoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
    final ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginVO loginVO) {
        try {
            loginService.login(loginVO);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
