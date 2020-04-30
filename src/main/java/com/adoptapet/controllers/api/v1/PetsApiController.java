package com.adoptapet.controllers.api.v1;


import com.adoptapet.models.PetType;
import com.adoptapet.repositories.PetTypesRepository;
import com.adoptapet.repositories.PetTypesRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pets")
public class PetsApiController {
  @Autowired
  private PetTypesRepository petTypesRepository;
  @GetMapping
  public Iterable<PetType> getList(){
    return petTypesRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<PetType> getIndividualItem(@PathVariable Integer id){
    return petTypesRepository.findById(id);
  }
  @PostMapping
  public PetType create(@RequestBody PetType petType) {
    return petTypesRepository.save(petType);
  }
}
