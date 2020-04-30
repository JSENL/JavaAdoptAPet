package com.adoptapet.repositories;
import com.adoptapet.models.AdoptablePet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptablePetRepository extends PagingAndSortingRepository<AdoptablePet, Integer> {
}