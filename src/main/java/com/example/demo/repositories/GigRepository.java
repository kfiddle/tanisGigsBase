package com.example.demo.repositories;

import com.example.demo.models.Gig;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface GigRepository extends CrudRepository<Gig, Long> {

    Collection<Gig> findAll(Sort sort);
}
