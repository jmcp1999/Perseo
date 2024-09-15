package com.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Models.Experience;
import com.example.Repositories.IExperienceRepository;

@Service
public class ExperienceService {

      @Autowired IExperienceRepository iExperienceRepository;

  public Experience createExperience(Experience newExperience) {
    return iExperienceRepository.save(newExperience);
  }

  public List<Experience> getAllExperience() {
    return (List<Experience>) iExperienceRepository.findAll();
  }

  public Optional<Experience> getExperienceById(int id) {
    Experience experience = iExperienceRepository.findById(id).orElseThrow();
    return Optional.of(experience);
  }

  public void updateExperience(Experience experience, int id) {
    experience.setId(id);
    iExperienceRepository.save(experience);
  }

  public void deleteExperience(int id) {
    iExperienceRepository.deleteById(id);
  }

}
