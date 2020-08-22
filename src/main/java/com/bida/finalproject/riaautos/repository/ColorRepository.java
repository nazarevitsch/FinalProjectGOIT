package com.bida.finalproject.riaautos.repository;

import com.bida.finalproject.riaautos.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
}
