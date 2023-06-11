package com.unit.presente.model.entity;

import java.util.UUID;

import com.unit.presente.model.VO.UserVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Usuários")
public class User {

    @Id
    @GeneratedValue
    public UUID id;

    @Column(name = "Name")
    public String name;

    @Column(name = "CPF")
    public String cpf;

    @Column(name = "Password")
    public String password;

    @Column(name = "Email")
    public String email;

    public User(UserVO userVo) {
        this.name = userVo.name;
        this.cpf = userVo.cpf;
        this.password = userVo.password;
        this.email = userVo.email;
    }
}
