package com.bezkoder.spring.jpa.postgresql;

import com.bezkoder.spring.jpa.postgresql.model.RobotDto;
import com.bezkoder.spring.jpa.postgresql.repository.RobotRepository;
import com.bezkoder.spring.jpa.postgresql.service.RobotService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

@Log4j2
@Controller
public class GreetingController {

    @Autowired
    RobotRepository robotRepository;

    @Autowired
    RobotService robotService;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(SelectEnemy message) throws Exception {
        log.info("ok");
        String bot = bot(message.getEnemy(), message.getSelectRobot());
        return new Greeting(bot + " " + botRandomAttack());
    }

    //@SendTo("/topic/greetings")
    public String bot(BigInteger enemy, BigInteger robot) {

        int result = robotService.attack(enemy, robot);
        RobotDto Enemy = robotService.getFromEntity(robotService.getRobotById(enemy));

        return "My turn : " + Enemy.getName() + " hp remain: " + result;
    }

    public String botRandomAttack() {
        int enemy = RobotService.random(12, 14);
        int myRobot = RobotService.random(15, 17);

        int result = robotService.attack(BigInteger.valueOf(enemy), BigInteger.valueOf(myRobot));

        RobotDto Enemy = robotService.getFromEntity(robotService.getRobotById(BigInteger.valueOf(enemy)));
        RobotDto we = robotService.getFromEntity(robotService.getRobotById(BigInteger.valueOf(myRobot)));

        return "| Enemy turn: " + Enemy.getName() + " attack " + we.getName() + " hp remain: " + result;
    }
}
