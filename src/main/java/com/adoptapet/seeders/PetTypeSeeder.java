package com.adoptapet.seeders;

import com.adoptapet.models.PetType;
import com.adoptapet.repositories.PetTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetTypeSeeder {
  private final PetTypesRepository petsRepo;

  @Autowired
  public PetTypeSeeder(PetTypesRepository petsRepo) {
    this.petsRepo = petsRepo;
  }

  public void seed() {
    if (petsRepo.count() == 0) {
      PetType guinea = new PetType();
      guinea.setType("guinea pig");
      guinea.setDescription("Domesticated rodent");
      petsRepo.save(guinea);

      PetType reptile = new PetType();
      reptile.setType("reptile");
      reptile.setDescription("Domesticated questionable enemy");
      petsRepo.save(reptile);
    }
  }
}
