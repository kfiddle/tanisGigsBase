package com.example.demo.controllers;


import com.example.demo.models.Gig;
import com.example.demo.repositories.GigRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
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

    @PostMapping("/delete-gig")
    public Collection<Gig> deleteGigFromDatabase(@RequestBody Gig performanceToDelete) throws IOException {
        if (gigRepo.existsById(performanceToDelete.getId())) {
            gigRepo.deleteById(performanceToDelete.getId());
        }
        return (Collection<Gig>) gigRepo.findAll();
    }

    @PostMapping("add-or-edit-gig")
    public Collection<Gig> addGigToDatabase(@RequestBody Gig gigToAdd) throws IOException {

        try {

            Gig newGig = new Gig();
            gigRepo.save(newGig);


        } catch (
                Exception error) {
            error.printStackTrace();

        }
        return (Collection<Gig>) gigRepo.findAll();
    }


}
