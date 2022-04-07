package com.bezkoder.spring.jpa.postgresql.repository;

import com.bezkoder.spring.jpa.postgresql.model.Robot;
import com.bezkoder.spring.jpa.postgresql.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface RobotRepository extends JpaRepository<Robot, BigInteger> {

}
