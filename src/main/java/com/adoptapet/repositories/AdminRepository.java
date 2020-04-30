package com.adoptapet.repositories;
import com.adoptapet.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminRepository extends PagingAndSortingRepository<Admin, Integer> {
}
