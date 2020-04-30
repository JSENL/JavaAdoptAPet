package com.adoptapet.seeders;

import com.adoptapet.models.Pet;
import com.adoptapet.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetSeeders {
  private final PetsRepository petsRepo;

  @Autowired
  public PetSeeders(PetsRepository petsRepo) {
    this.petsRepo = petsRepo;
  }

  public void seed() {
    if (petsRepo.count() == 0) {
      Pet guinea = new Pet();
      guinea.setType("guinea pig");
      guinea.setDescription("Domesticated rodent");
      petsRepo.save(guinea);

      Pet reptile = new Pet();
      reptile.setType("reptile");
      reptile.setDescription("Domesticated questionable enemy");
      petsRepo.save(reptile);
    }
  }
}
