package com.adoptapet.seeders;

import com.adoptapet.models.PetType;
import com.adoptapet.repositories.PetTypesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PetTypeSeeder implements CommandLineRunner {
  @Autowired
  private final PetTypesRepository petsRepo;

  @Autowired
  public PetTypeSeeder(PetTypesRepository petsRepo) {
    this.petsRepo = petsRepo;
  }
  @Override
  public void run(String... args) throws Exception {
   List<PetType> petTypes = new ArrayList<PetType>();
      PetType guinea = new PetType();
      guinea.setType("guinea pig");
      guinea.setDescription("Domesticated rodent");
    petTypes.add(guinea);

      PetType reptile = new PetType();
      reptile.setType("reptile");
      reptile.setDescription("Domesticated questionable enemy");
    petTypes.add(reptile);

    if (petsRepo.count() == 0) {
      for(PetType petType : petTypes){
        petsRepo.save(petType);
      }
    }
    }
  }

