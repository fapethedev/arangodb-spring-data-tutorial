package com.fapethedev.arangodb.sdt.runner;

import com.fapethedev.arangodb.sdt.entity.ChildOf;
import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import com.fapethedev.arangodb.sdt.repository.ChildOfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

@RequiredArgsConstructor
public class RelationsRunner implements CommandLineRunner {

    private final CharacterRepository characterRepo;
    private final ChildOfRepository childOfRepo;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("# Relations");
        characterRepo.saveAll(CrudRunner.createCharacters());

        // first create some relations for the Starks and Lannisters
        characterRepo.findByNameAndSurname("Ned", "Stark").ifPresent(ned -> {
            characterRepo.findByNameAndSurname("Catelyn", "Stark").ifPresent(catelyn -> {
                characterRepo.findByNameAndSurname("Robb", "Stark").ifPresent(robb -> childOfRepo.saveAll(Arrays.asList(new ChildOf(robb, ned), new ChildOf(robb, catelyn))));
                characterRepo.findByNameAndSurname("Sansa", "Stark").ifPresent(sansa -> childOfRepo.saveAll(Arrays.asList(new ChildOf(sansa, ned), new ChildOf(sansa, catelyn))));
                characterRepo.findByNameAndSurname("Arya", "Stark").ifPresent(arya -> childOfRepo.saveAll(Arrays.asList(new ChildOf(arya, ned), new ChildOf(arya, catelyn))));
                characterRepo.findByNameAndSurname("Bran", "Stark").ifPresent(bran -> childOfRepo.saveAll(Arrays.asList(new ChildOf(bran, ned), new ChildOf(bran, catelyn))));
            });
            characterRepo.findByNameAndSurname("Jon", "Snow")
                    .ifPresent(bran -> childOfRepo.save(new ChildOf(bran, ned)));
        });

        characterRepo.findByNameAndSurname("Tywin", "Lannister").ifPresent(tywin -> {
            characterRepo.findByNameAndSurname("Jaime", "Lannister").ifPresent(jaime -> {
                childOfRepo.save(new ChildOf(jaime, tywin));
                characterRepo.findByNameAndSurname("Cersei", "Lannister").ifPresent(cersei -> {
                    childOfRepo.save(new ChildOf(cersei, tywin));
                    characterRepo.findByNameAndSurname("Joffrey", "Baratheon").ifPresent(joffrey -> childOfRepo.saveAll(Arrays.asList(new ChildOf(joffrey, jaime), new ChildOf(joffrey, cersei))));
                });
            });
            characterRepo.findByNameAndSurname("Tyrion", "Lannister")
                    .ifPresent(tyrion -> childOfRepo.save(new ChildOf(tyrion, tywin)));
        });

        characterRepo.findByNameAndSurname("Ned", "Stark").ifPresent(nedStark -> {
            System.out.printf("## These are the children of %s:%n", nedStark);
            nedStark.getChildren().forEach(System.out::println);
        });
    }

}
