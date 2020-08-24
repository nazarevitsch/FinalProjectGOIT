package com.bida.finalproject.riaautos.repository;

import com.bida.finalproject.riaautos.domain.SearchVersionForWEB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchVersionForWEBRepository extends JpaRepository<SearchVersionForWEB, Long> {

    public List<SearchVersionForWEB> findAllByUsername(String username);
}
