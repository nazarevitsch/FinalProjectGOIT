package com.bida.finalproject.riaautos.repository;

import com.bida.finalproject.riaautos.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {
}
