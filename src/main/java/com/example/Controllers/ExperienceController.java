package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Models.Experience;
import com.example.Services.ExperienceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/experience")
@CrossOrigin(origins = "*", maxAge = 3600)

public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @PostMapping(path = "post")
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);

    }

    @GetMapping(path = "get")
    public List<Experience> getAllExperience(){
        return experienceService.getAllExperience();
    }

    @GetMapping(path = "get/{id}")
    public Optional<Experience> getExperienceById(@PathVariable int id){
        return experienceService.getExperienceById(id);

    }

    @PutMapping(path = "put/{id}")
    public void  updateExperience(@RequestBody Experience experience, @PathVariable int id){
        experienceService.updateExperience(experience, id);

    }

    @DeleteMapping(path = "delete/{id}")
        public void deleteDonations(@PathVariable int id) {
            experienceService.deleteExperience(id);
    }

}
