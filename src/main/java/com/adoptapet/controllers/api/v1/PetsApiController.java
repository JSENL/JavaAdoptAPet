package com.adoptapet.controllers.api.v1;


import com.adoptapet.models.Pet;
import com.adoptapet.models.Pet;
import com.adoptapet.repositories.PetsRepository;
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
@RequestMapping
public class PetsApiController {
  @Autowired
  private PetsRepository petsRepository;
  @GetMapping("api/v1/pets")
  public Iterable<Pet> getList(){
    return petsRepository.findAll();
  }

  @GetMapping("api/v1/pets/{id}")
  public Optional<Pet> getIndividualItem(@PathVariable Integer id){
    return petsRepository.findById(id);
  }
  @PostMapping
  public Pet create(@RequestBody Pet pet) {
    return petsRepository.save(pet);
  }
}
