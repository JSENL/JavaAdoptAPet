package com.adoptapet.seeders;

import com.adoptapet.models.AdoptablePet;
import com.adoptapet.models.Pet;
import com.adoptapet.repositories.AdoptablePetRepository;
import com.adoptapet.repositories.PetsRepository;
import com.adoptapet.models.*;
import com.adoptapet.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdoptablePetsSeeder {
  private final AdoptablePetRepository adoptablePetRepo;
  private final PetsRepository petsRepo;

  @Autowired
  public AdoptablePetsSeeder(AdoptablePetRepository adoptablePetRepo, PetsRepository petsRepo) {
    this.adoptablePetRepo = adoptablePetRepo;
    this.petsRepo = petsRepo;
  }

  public void seed() {
    if (adoptablePetRepo.count() == 0) {
      AdoptablePet adoptablePet = new AdoptablePet();
      adoptablePet.setName("Helena");
      adoptablePet.setImgUrl("https://www.reptilecentre.com/images/wmfixed/Reptile/frozen-guinea-pig-v1-495-495.jpg?v=2");
      adoptablePet.setAge(3);
      adoptablePet.setVaccinationStatus(true);
      adoptablePet.setAdoptionStory("Is a sweet guineapig that loves belly rubs.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(1).get());
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Artemis");
      adoptablePet.setImgUrl("https://lafeber.com/vet/wp-content/uploads/Veiled-chameleon-by-Mrs-Logic-cropped-square.jpg");
      adoptablePet.setAge(5);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("Is a chameleon that gets excited at the sight of lettuce.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Rocky");
      adoptablePet.setImgUrl("https://cdn.mos.cms.futurecdn.net/gJJFamQca86CibEeDmegk-1024-80.jpg");
      adoptablePet.setAge(7);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("Is a ornery guineapig that hates belly rubs.");
      adoptablePet.setAdoptionStatus("'Pending'");
      adoptablePet.setPet(petsRepo.findById(1).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Harry");
      adoptablePet.setImgUrl("https://img1.grunge.com/img/gallery/the-truth-about-why-there-arent-snakes-in-ireland/intro-1547479326.jpg");
      adoptablePet.setAge(2);
      adoptablePet.setVaccinationStatus(true);
      adoptablePet.setAdoptionStory("Is a snake with a huge appetite for bunnies.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Sticky");
      adoptablePet.setImgUrl("https://live.staticflickr.com/8576/15166690374_6dcf167afa_b.jpg");
      adoptablePet.setAge(1);
      adoptablePet.setVaccinationStatus(true);
      adoptablePet.setAdoptionStory("This guy loves crickets");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Pancake");
      adoptablePet.setImgUrl("https://i.pinimg.com/originals/f8/bc/80/f8bc8082646c8bc7e7a87b9d6b02543f.jpg");
      adoptablePet.setAge(4);
      adoptablePet.setVaccinationStatus(true);
      adoptablePet.setAdoptionStory("This guy loves to lounge around");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(1).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Dino");
      adoptablePet.setImgUrl("https://www.zillarules.com/-/media/images/zilla-na/us/blog-articles/myths-facts-about-bearded-dragon-care/bearded-dragon.jpg?h=350&w=350&la=en&hash=BB45C333590D6C0AF6E426FC419D6A3B224212BE");
      adoptablePet.setAge(3);
      adoptablePet.setVaccinationStatus(true);
      adoptablePet.setAdoptionStory("Great lizard just looking to play.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Nibbles");
      adoptablePet.setImgUrl("https://storage.needpix.com/rsynced_images/guinea-pig-850563_1280.jpg");
      adoptablePet.setAge(1);
      adoptablePet.setVaccinationStatus(true);
      adoptablePet.setAdoptionStory("He will chew everything, right into your heart.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(1).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Sharkeisha");
      adoptablePet.setImgUrl("https://i.pinimg.com/236x/33/a2/ee/33a2ee6acf44268d81d9021a654f06e0.jpg");
      adoptablePet.setAge(2);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("Baby Shark doo doo doo doo dooo, also likes lettuce.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(1).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("ChamWow");
      adoptablePet.setImgUrl("https://www.cbreptile.com/wp-content/uploads/2017/08/ambilobe-panther-chameleon-breeder.jpg");
      adoptablePet.setAge(4);
      adoptablePet.setVaccinationStatus(true);
      adoptablePet.setAdoptionStory("Will do what he needs to do to change. Just for you.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Brownies");
      adoptablePet.setImgUrl("https://i.pinimg.com/originals/4d/b4/06/4db406f8c896c14f2a0dfa64e2744e79.jpg");
      adoptablePet.setAge(5);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("Loves mice! Not for friends or play play though.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Napsy");
      adoptablePet.setImgUrl("https://media.giphy.com/media/ZLF9Loju0q3MA/giphy.gif");
      adoptablePet.setAge(3);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("You will see her in your dreams.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Connakry");
      adoptablePet.setImgUrl("https://media1.giphy.com/media/9ryDmaTgXFc90a6fah/giphy.gif");
      adoptablePet.setAge(1);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("Ready or not here I come. Oh there you are hiding!! Likes to existentially think of life.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(1).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Orange Fanta");
      adoptablePet.setImgUrl("https://cdn.pixabay.com/photo/2014/10/22/19/21/guinea-pig-498824__340.jpg");
      adoptablePet.setAge(3);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("Loves carrots and will love you too.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(1).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Megan Thee Guinea Pig");
      adoptablePet.setImgUrl("https://merryabouttown.com/wp-content/uploads/2019/04/guinea-pig-1325841_1280.jpg");
      adoptablePet.setAge(15);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("She got him swerving and breaking the law These windows tinted so nobody saw.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(1).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);

      adoptablePet = new AdoptablePet();
      adoptablePet.setName("Boxy Brown");
      adoptablePet.setImgUrl("https://farm2.staticflickr.com/1889/43040326120_715b221842_b.jpg");
      adoptablePet.setAge(10);
      adoptablePet.setVaccinationStatus(false);
      adoptablePet.setAdoptionStory("Love lettuce, walking, and beating up the man you jive turkey.");
      adoptablePet.setAdoptionStatus("Pending");
      adoptablePet.setPet(petsRepo.findById(2).orElse(new Pet()));
      adoptablePetRepo.save(adoptablePet);
    }
  }
}
