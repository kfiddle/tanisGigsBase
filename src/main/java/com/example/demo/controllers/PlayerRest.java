package com.example.demo.controllers;


import com.example.demo.enums.InstrumentEnum;
import com.example.demo.models.Player;
import com.example.demo.repositories.GigRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


}
