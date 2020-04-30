package com.adoptapet.controllers;

import com.adoptapet.models.PetType;
import com.adoptapet.repositories.PetTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetsController {
  @Autowired
  private PetTypesRepository petTypesRepository;

  @GetMapping
  public String getAll(Model model) {
    throw new RuntimeException();
    //model.addAttribute("pets", petTypesRepository.findAll());
    //return "static/index";
  }


  @GetMapping("/new")
  public String getNew(@Autowired PetType petType, Model model) {
   model.addAttribute("pet", petType);
    return "pets/new";
  }
}
