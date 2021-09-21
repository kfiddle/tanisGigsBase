package com.example.demo;

import com.example.demo.models.Player;
import com.example.demo.repositories.GigRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.parameters.P;

import javax.annotation.Resource;

public class Populator implements CommandLineRunner {

    @Resource
    PlayerRepository playerRepo;

    @Resource
    GigRepository gigRepo;

    @Override
    public void run(String... args) throws Exception {

        Player tanis = new Player("Tanis", "Mrrrrrrrrimee");
        Player mike = new Player("Michael", "TheHufster");
        Player sam = new Player("Sam", "Petry");
        Player laura = new Player("Laura", "Shuster");

        playerRepo.save(tanis);
        playerRepo.save(mike);
        playerRepo.save(sam);
        playerRepo.save(laura);



    }
}
