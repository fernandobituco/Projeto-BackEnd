package com.unit.presente.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unit.presente.model.VO.UserVO;
import com.unit.presente.service.interfaces.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {

    final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> GetUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody UserVO user) {

        String fact = new String();
        try {
            userService.create(user);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok().body(fact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> Update(@PathVariable (value = "id") UUID id, @RequestBody UserVO user) {
        try {
            userService.update(user, id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Delete(@PathVariable (value = "id") UUID id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
