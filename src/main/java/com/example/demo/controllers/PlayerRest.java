package com.example.demo.controllers;


import com.example.demo.enums.InstrumentEnum;
import com.example.demo.models.Player;
import com.example.demo.repositories.GigRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

@CrossOrigin
@RestController
public class PlayerRest {

    @Resource
    PlayerRepository playerRepo;

    @Resource
    GigRepository gigRepo;

    @RequestMapping("/get-all-players")
    public Collection<Player> getAllPlayers() {
        return playerRepo.findAll(Sort.by("lastName"));
    }

    @RequestMapping("/{instrument}")
    public Collection<Player> getPlayersByInstrument(@PathVariable InstrumentEnum instrument) {
        return playerRepo.findByInstrumentEnum(instrument, Sort.by("lastName"));
    }

    @PostMapping("/add-or-edit-player")
    public Collection<Player> addPlayerToDatabase(@RequestBody Player incomingPlayer) throws IOException {

        try {

            if (incomingPlayer.getId() == null) {
                if (playerRepo.existsByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName())) {
                    return (Collection<Player>) playerRepo.findAll();
                } else {
                    Player playerToAdd = new Player(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());
                    playerToAdd.setAllProps(incomingPlayer);
                    playerRepo.save(playerToAdd);
                    System.out.println(playerToAdd.getFirstNameArea() + "   " + playerToAdd.getLastName() + "  " + playerToAdd.getInstrumentEnum());
                }
            } else if (playerRepo.findById(incomingPlayer.getId()).isPresent()) {
                Player playerToEdit = playerRepo.findById(incomingPlayer.getId()).get();
                playerToEdit.setAllProps(incomingPlayer);
                playerRepo.save(playerToEdit);
            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return (Collection<Player>) playerRepo.findAll();
    }


}
