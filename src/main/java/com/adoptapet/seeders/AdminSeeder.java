package com.adoptapet.seeders;

import com.adoptapet.models.Admin;
import com.adoptapet.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder {
  private final AdminRepository adminRepo;

  @Autowired
  public AdminSeeder(AdminRepository adminRepo) {
    this.adminRepo = adminRepo;
  }

  public void seed() {
    if (adminRepo.count() == 0) {
      Admin admin = new Admin();
      admin.setName("Nino Brown");
      admin.setUsername("password");
      admin.setPassword("password");
      adminRepo.save(admin);
    }
  }
}