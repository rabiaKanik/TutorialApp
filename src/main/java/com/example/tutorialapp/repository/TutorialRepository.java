package com.example.tutorialapp.repository;


import com.example.tutorialapp.model.Tutorial;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TutorialRepository {
    public List<Tutorial> findAll() {
        return null;
    }

    public Iterable<Object> findByTitleContaining(String title) {
        return null;
    }


}
