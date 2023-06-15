package com.unit.presente.model.entity;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.unit.presente.model.VO.PresenceVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Agendamentos")
public class Presence {
    
    @Id
    @GeneratedValue
    UUID id;

    @Column(name = "data")
    Date date;

    @Column(name = "checked")
    boolean checked = false;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="usuario_id")
    User user;

    public Presence(PresenceVO presenceVO, User user) {
        this.date = presenceVO.getDate();
        this.user = user;
    }

    
}
