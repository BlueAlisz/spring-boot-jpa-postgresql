package com.bezkoder.spring.jpa.postgresql;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class SelectEnemy {

    private BigInteger enemy;
    private BigInteger selectRobot;

    public SelectEnemy() {
    }

    public SelectEnemy(BigInteger enemy, BigInteger selectRobot) {
        this.enemy = enemy;
        this.selectRobot = selectRobot;
    }



}
