package com.adoptapet.controllers;

import com.adoptapet.models.Pet;
import com.adoptapet.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PetsControllers {
  @Autowired
  private PetsRepository petsRepository;
  @GetMapping("/pets/index")
  public String getAll(Model model) {
    model.addAttribute("pets", petsRepository.findAll());
    return "pets/index";
  }

  @GetMapping("/pets/index/{page}")
  public String getAllPets(@PathVariable int page, Model model) {
  Pageable pageable = PageRequest.of(page, 10);
    model.addAttribute("pets", petsRepository.findAll());
    return "pets/index";
  }

  @GetMapping("/pets/new")
  public String getNew(@Autowired Pet pet, Model model) {
   model.addAttribute("pet", pet);
    return "pets/new";
  }
  }
