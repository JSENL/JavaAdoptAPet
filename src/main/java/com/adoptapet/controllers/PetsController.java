package com.adoptapet.controllers;

import com.adoptapet.models.PetType;
import com.adoptapet.repositories.PetTypesRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetsController {
  @Autowired
  private PetTypesRepository petTypesRepository;

  @GetMapping
  public String getAll(Model model) {
//    model.addAttribute("pets", petTypesRepository.findAll());
    model.addAttribute("pets", new ArrayList<PetType>());
    return "static/index";
  }


  @GetMapping("/new")
  public String getNew(Model model) {
//    model.addAttribute("pet", petType);
    return "pets/new";
  }
}
