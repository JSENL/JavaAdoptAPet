package com.adoptapet.seeders;

import com.adoptapet.models.AdoptablePet;
import com.adoptapet.models.PetType;
import com.adoptapet.repositories.AdoptablePetRepository;
import com.adoptapet.repositories.PetTypesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdoptablePetsSeeder implements CommandLineRunner {
  @Autowired
  private final AdoptablePetRepository adoptablePetRepo;
  private final PetTypesRepository petsRepo;


  public AdoptablePetsSeeder(AdoptablePetRepository adoptablePetRepo, PetTypesRepository petsRepo) {
    this.adoptablePetRepo = adoptablePetRepo;
    this.petsRepo = petsRepo;
  }

  @Override
  public void run(String... args) throws Exception{
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
      for(PetType petType : petTypes) {
        petsRepo.save(guinea);
        petsRepo.save(reptile);
      }
    }

      AdoptablePet adoptablePetOne = new AdoptablePet();
      adoptablePetOne.setName("Helena");
      adoptablePetOne.setImgUrl("https://www.reptilecentre.com/images/wmfixed/Reptile/frozen-guinea-pig-v1-495-495.jpg?v=2");
      adoptablePetOne.setAge(3);
      adoptablePetOne.setVaccinationStatus(true);
      adoptablePetOne.setAdoptionStory("Is a sweet guineapig that loves belly rubs.");
      adoptablePetOne.setAdoptionStatus("Pending");
      adoptablePetOne.setPetType(petsRepo.findById(1).get());
      adoptablePetRepo.save(adoptablePetOne);

    AdoptablePet adoptablePetTwo = new AdoptablePet();
      adoptablePetTwo.setName("Artemis");
      adoptablePetTwo.setImgUrl("https://lafeber.com/vet/wp-content/uploads/Veiled-chameleon-by-Mrs-Logic-cropped-square.jpg");
      adoptablePetTwo.setAge(5);
      adoptablePetTwo.setVaccinationStatus(false);
      adoptablePetTwo.setAdoptionStory("Is a chameleon that gets excited at the sight of lettuce.");
      adoptablePetTwo.setAdoptionStatus("Pending");
      adoptablePetTwo.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetTwo);

    AdoptablePet adoptablePetThree = new AdoptablePet();
      adoptablePetThree.setName("Rocky");
      adoptablePetThree.setImgUrl("https://cdn.mos.cms.futurecdn.net/gJJFamQca86CibEeDmegk-1024-80.jpg");
      adoptablePetThree.setAge(7);
      adoptablePetThree.setVaccinationStatus(false);
      adoptablePetThree.setAdoptionStory("Is a ornery guineapig that hates belly rubs.");
      adoptablePetThree.setAdoptionStatus("'Pending'");
      adoptablePetThree.setPetType(petsRepo.findById(1).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetThree);

    AdoptablePet adoptablePetFour = new AdoptablePet();
      adoptablePetFour.setName("Harry");
      adoptablePetFour.setImgUrl("https://img1.grunge.com/img/gallery/the-truth-about-why-there-arent-snakes-in-ireland/intro-1547479326.jpg");
      adoptablePetFour.setAge(2);
      adoptablePetFour.setVaccinationStatus(true);
      adoptablePetFour.setAdoptionStory("Is a snake with a huge appetite for bunnies.");
      adoptablePetFour.setAdoptionStatus("Pending");
      adoptablePetFour.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetFour);

    AdoptablePet adoptablePetFive = new AdoptablePet();
      adoptablePetFive.setName("Sticky");
      adoptablePetFive.setImgUrl("https://live.staticflickr.com/8576/15166690374_6dcf167afa_b.jpg");
    adoptablePetFive.setAge(1);
    adoptablePetFive.setVaccinationStatus(true);
    adoptablePetFive.setAdoptionStory("This guy loves crickets");
    adoptablePetFive.setAdoptionStatus("Pending");
    adoptablePetFive.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetFive);

    AdoptablePet adoptablePetSix = new AdoptablePet();
    adoptablePetSix.setName("Pancake");
    adoptablePetSix.setImgUrl("https://i.pinimg.com/originals/f8/bc/80/f8bc8082646c8bc7e7a87b9d6b02543f.jpg");
    adoptablePetSix.setAge(4);
    adoptablePetSix.setVaccinationStatus(true);
    adoptablePetSix.setAdoptionStory("This guy loves to lounge around");
    adoptablePetSix.setAdoptionStatus("Pending");
    adoptablePetSix.setPetType(petsRepo.findById(1).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetSix);

    AdoptablePet adoptablePetSeven = new AdoptablePet();
    adoptablePetSeven.setName("Dino");
    adoptablePetSeven.setImgUrl("https://www.zillarules.com/-/media/images/zilla-na/us/blog-articles/myths-facts-about-bearded-dragon-care/bearded-dragon.jpg?h=350&w=350&la=en&hash=BB45C333590D6C0AF6E426FC419D6A3B224212BE");
    adoptablePetSeven.setAge(3);
    adoptablePetSeven.setVaccinationStatus(true);
    adoptablePetSeven.setAdoptionStory("Great lizard just looking to play.");
    adoptablePetSeven.setAdoptionStatus("Pending");
    adoptablePetSeven.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetSeven);

    AdoptablePet adoptablePetEight = new AdoptablePet();
    adoptablePetEight.setName("Nibbles");
    adoptablePetEight.setImgUrl("https://storage.needpix.com/rsynced_images/guinea-pig-850563_1280.jpg");
    adoptablePetEight.setAge(1);
    adoptablePetEight.setVaccinationStatus(true);
    adoptablePetEight.setAdoptionStory("He will chew everything, right into your heart.");
    adoptablePetEight.setAdoptionStatus("Pending");
    adoptablePetEight.setPetType(petsRepo.findById(1).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetEight);

    AdoptablePet adoptablePetNine = new AdoptablePet();
    adoptablePetNine.setName("Sharkeisha");
    adoptablePetNine.setImgUrl("https://i.pinimg.com/236x/33/a2/ee/33a2ee6acf44268d81d9021a654f06e0.jpg");
    adoptablePetNine.setAge(2);
    adoptablePetNine.setVaccinationStatus(false);
    adoptablePetNine.setAdoptionStory("Baby Shark doo doo doo doo dooo, also likes lettuce.");
    adoptablePetNine.setAdoptionStatus("Pending");
    adoptablePetNine.setPetType(petsRepo.findById(1).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetNine);

    AdoptablePet  adoptablePetTen = new AdoptablePet();
    adoptablePetTen.setName("ChamWow");
    adoptablePetTen.setImgUrl("https://www.cbreptile.com/wp-content/uploads/2017/08/ambilobe-panther-chameleon-breeder.jpg");
    adoptablePetTen.setAge(4);
    adoptablePetTen.setVaccinationStatus(true);
    adoptablePetTen.setAdoptionStory("Will do what he needs to do to change. Just for you.");
    adoptablePetTen.setAdoptionStatus("Pending");
    adoptablePetTen.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetTen);

    AdoptablePet  adoptablePetEleven = new AdoptablePet();
    adoptablePetEleven.setName("Brownies");
    adoptablePetEleven.setImgUrl("https://i.pinimg.com/originals/4d/b4/06/4db406f8c896c14f2a0dfa64e2744e79.jpg");
    adoptablePetEleven.setAge(5);
    adoptablePetEleven.setVaccinationStatus(false);
    adoptablePetEleven.setAdoptionStory("Loves mice! Not for friends or play play though.");
    adoptablePetEleven.setAdoptionStatus("Pending");
    adoptablePetEleven.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetEleven);

    AdoptablePet  adoptablePetTwelve = new AdoptablePet();
    adoptablePetTwelve.setName("Napsy");
    adoptablePetTwelve.setImgUrl("https://media.giphy.com/media/ZLF9Loju0q3MA/giphy.gif");
    adoptablePetTwelve.setAge(3);
    adoptablePetTwelve.setVaccinationStatus(false);
    adoptablePetTwelve.setAdoptionStory("You will see her in your dreams.");
    adoptablePetTwelve.setAdoptionStatus("Pending");
    adoptablePetTwelve.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetTwelve);

    AdoptablePet adoptablePetThirteen = new AdoptablePet();
    adoptablePetThirteen.setName("Connakry");
    adoptablePetThirteen.setImgUrl("https://media1.giphy.com/media/9ryDmaTgXFc90a6fah/giphy.gif");
    adoptablePetThirteen.setAge(1);
    adoptablePetThirteen.setVaccinationStatus(false);
    adoptablePetThirteen.setAdoptionStory("Ready or not here I come. Oh there you are hiding!! Likes to existentially think of life.");
    adoptablePetThirteen.setAdoptionStatus("Pending");
    adoptablePetThirteen.setPetType(petsRepo.findById(1).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetThirteen);

    AdoptablePet adoptablePetFourteen = new AdoptablePet();
    adoptablePetFourteen.setName("Orange Fanta");
    adoptablePetFourteen.setImgUrl("https://cdn.pixabay.com/photo/2014/10/22/19/21/guinea-pig-498824__340.jpg");
    adoptablePetFourteen.setAge(3);
    adoptablePetFourteen.setVaccinationStatus(false);
    adoptablePetFourteen.setAdoptionStory("Loves carrots and will love you too.");
    adoptablePetFourteen.setAdoptionStatus("Pending");
    adoptablePetFourteen.setPetType(petsRepo.findById(1).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetFourteen);

    AdoptablePet  adoptablePetFifteen = new AdoptablePet();
    adoptablePetFifteen.setName("Megan Thee Guinea Pig");
    adoptablePetFifteen.setImgUrl("https://merryabouttown.com/wp-content/uploads/2019/04/guinea-pig-1325841_1280.jpg");
    adoptablePetFifteen.setAge(15);
    adoptablePetFifteen.setVaccinationStatus(false);
    adoptablePetFifteen.setAdoptionStory("She got him swerving and breaking the law These windows tinted so nobody saw.");
    adoptablePetFifteen.setAdoptionStatus("Pending");
    adoptablePetFifteen.setPetType(petsRepo.findById(1).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetFifteen);

    AdoptablePet adoptablePetSixteen = new AdoptablePet();
    adoptablePetSixteen.setName("Boxy Brown");
    adoptablePetSixteen.setImgUrl("https://farm2.staticflickr.com/1889/43040326120_715b221842_b.jpg");
    adoptablePetSixteen.setAge(10);
    adoptablePetSixteen.setVaccinationStatus(false);
    adoptablePetSixteen.setAdoptionStory("Love lettuce, walking, and beating up the man you jive turkey.");
    adoptablePetSixteen.setAdoptionStatus("Pending");
    adoptablePetSixteen.setPetType(petsRepo.findById(2).orElse(new PetType()));
      adoptablePetRepo.save(adoptablePetSixteen);

    if (adoptablePetRepo.count() == 0) {
      adoptablePetRepo.save(adoptablePetOne);
      adoptablePetRepo.save(adoptablePetTwo);
      adoptablePetRepo.save(adoptablePetThree);
      adoptablePetRepo.save(adoptablePetFour);
      adoptablePetRepo.save(adoptablePetFive);
      adoptablePetRepo.save(adoptablePetSix);
      adoptablePetRepo.save(adoptablePetSeven);
      adoptablePetRepo.save(adoptablePetEight);
      adoptablePetRepo.save(adoptablePetNine);
      adoptablePetRepo.save(adoptablePetTen);
      adoptablePetRepo.save(adoptablePetEleven);
      adoptablePetRepo.save(adoptablePetTwelve);
      adoptablePetRepo.save(adoptablePetThirteen);
      adoptablePetRepo.save(adoptablePetFourteen);
      adoptablePetRepo.save(adoptablePetFifteen);
      adoptablePetRepo.save(adoptablePetSixteen);
    }
     }
    }

