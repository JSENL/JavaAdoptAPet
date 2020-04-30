package com.adoptapet.repositories;

import com.adoptapet.models.AdoptionApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionApplicationRepository extends
    PagingAndSortingRepository<AdoptionApplication, Integer> {

}