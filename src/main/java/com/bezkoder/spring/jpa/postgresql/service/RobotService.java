package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.model.Robot;
import com.bezkoder.spring.jpa.postgresql.model.RobotDto;
import com.bezkoder.spring.jpa.postgresql.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
public class RobotService {
    @Autowired
    RobotRepository robotRepository;

    @Transactional
    public Robot save(Robot robot){
        return robotRepository.save(robot);
    }

    public Robot getRobotById(BigInteger robotId) {
        return robotRepository.findById(robotId).orElse(null);
    }

    public RobotDto getFromEntity(Robot robot){
        RobotDto robotDto = new RobotDto();
        robotDto.setId(robot.getId());
        robotDto.setName(robot.getName());
        robotDto.setHp(robot.getHp());
        robotDto.setAttack(robot.getAttack());

        return robotDto;
    }

    public int attack(BigInteger enemyId, BigInteger robotId){
        Robot thisEnemy = getRobotById(enemyId);
        Robot myRobot = getRobotById(robotId);

        int enemyHp = thisEnemy.getHp() - myRobot.getAttack();
        thisEnemy.setHp(enemyHp);

        save(thisEnemy);


        return enemyHp;
    }

    public static int random(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
