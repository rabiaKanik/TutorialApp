package com.example.tutorialapp.controller;
//https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
import com.example.tutorialapp.model.Tutorial;
import com.example.tutorialapp.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class TutorialController {
    @Autowired
    private TutorialRepository tutorialRepository;

    @GetMapping(value = "/tutorial")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title){
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            if (title == null){
                tutorialRepository.findAll().forEach(tutorials :: add);
            }else
                tutorialRepository.findByTitleContaining(title).forEach(tutorials :: add);
            if (tutorials.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id){
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()){
            return new ResponseEntity<>(tutorialData.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/tutorials")

    @PutMapping(value = "/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial){
        return null;
    }

}
