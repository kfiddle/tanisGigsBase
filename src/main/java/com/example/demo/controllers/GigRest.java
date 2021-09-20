package com.example.demo.controllers;


import com.example.demo.models.Gig;
import com.example.demo.repositories.GigRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class GigRest {

    @Resource
    PlayerRepository playerRepo;

    @Resource
    GigRepository gigRepo;


    @RequestMapping("/get-all-gigs")
    public Collection<Gig> getAllGigs() {
        return gigRepo.findAll(Sort.by("date"));
    }

}
