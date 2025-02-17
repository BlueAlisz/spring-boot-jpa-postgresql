package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.Robot;
import com.bezkoder.spring.jpa.postgresql.model.RobotDto;
import com.bezkoder.spring.jpa.postgresql.model.Tutorial;
import com.bezkoder.spring.jpa.postgresql.repository.RobotRepository;
import com.bezkoder.spring.jpa.postgresql.repository.TutorialRepository;
import com.bezkoder.spring.jpa.postgresql.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RobotController {


	@Autowired
	private RobotRepository robotRepository;

	@Autowired
	private RobotService robotService;

//	@GetMapping("/robots")
//	public ResponseEntity<List<Robot>> getAllTutorials() {
//		try {
//			List<Robot> robots = robotRepository.findAll();
//
//			if (robots.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//
//			return new ResponseEntity<>(robots, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@GetMapping("/robot/{id}")
	public ResponseEntity<RobotDto> getRobotById(@PathVariable("id") BigInteger id) {
		RobotDto robotData = robotService.getFromEntity(robotService.getRobotById(id));
		return ResponseEntity.ok(robotData);

	}

	@PostMapping("/robot")
	public ResponseEntity<Robot> createTutorial(@RequestBody Robot robot) {
		try {
			Robot oneRobot = robotRepository
					.save(new Robot(robot.getName(), robot.getHp(), robot.getAttack()));
			return new ResponseEntity<Robot>(oneRobot, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PutMapping("/tutorials/{id}")
//	public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//
//		if (tutorialData.isPresent()) {
//			Tutorial _tutorial = tutorialData.get();
//			_tutorial.setTitle(tutorial.getTitle());
//			_tutorial.setDescription(tutorial.getDescription());
//			_tutorial.setPublished(tutorial.isPublished());
//			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@DeleteMapping("/tutorials/{id}")
//	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//		try {
//			tutorialRepository.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@DeleteMapping("/tutorials")
//	public ResponseEntity<HttpStatus> deleteAllTutorials() {
//		try {
//			tutorialRepository.deleteAll();
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@GetMapping("/tutorials/published")
//	public ResponseEntity<List<Tutorial>> findByPublished() {
//		try {
//			List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
//
//			if (tutorials.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(tutorials, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}
