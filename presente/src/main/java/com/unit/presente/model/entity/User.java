package com.unit.presente.model.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unit.presente.model.VO.UserVO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    UUID id;

    @Column(name = "Name")
    String name;

    @Column(name = "CPF", unique = true)
    String cpf;

    @Column(name = "Password")
    String password;

    @Column(name = "Email", unique = true)
    String email;

    @Column(name = "Role")
    String role;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    Set<Presence> presences = new HashSet<>();

    public User(UserVO userVo) {
        this.name = userVo.getName();
        this.cpf = userVo.getCpf();
        this.password = userVo.getPassword();
        this.email = userVo.getEmail();
        this.role = userVo.getRole();
    }
}
