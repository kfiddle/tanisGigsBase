package com.example.demo.repositories;

import com.example.demo.enums.InstrumentEnum;
import com.example.demo.models.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PlayerRepository extends CrudRepository<Player, Long> {


    Collection<Player> findAll(Sort lastName);

    Collection<Player> findByInstrumentEnum(InstrumentEnum instrument, Sort lastName);

    boolean existsByFirstNameAreaAndLastName(String firstNameArea, String lastName);
}
