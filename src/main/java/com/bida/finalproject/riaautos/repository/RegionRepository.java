package com.bida.finalproject.riaautos.repository;

import com.bida.finalproject.riaautos.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
