package com.bezkoder.spring.jpa.postgresql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "robot")
public class Robot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "name")
    private String name;
    @Column(name = "hp")
    private int hp;
    @Column(name = "attack")
    private int attack;

    public Robot() {

    }

    public Robot(String name, int hp, int attack) {

        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

}
