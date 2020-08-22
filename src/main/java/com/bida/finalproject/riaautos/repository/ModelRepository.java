package com.bida.finalproject.riaautos.repository;

import com.bida.finalproject.riaautos.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
