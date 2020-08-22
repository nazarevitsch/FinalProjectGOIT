package com.bida.finalproject.riaautos.repository;

import com.bida.finalproject.riaautos.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String email);
}
