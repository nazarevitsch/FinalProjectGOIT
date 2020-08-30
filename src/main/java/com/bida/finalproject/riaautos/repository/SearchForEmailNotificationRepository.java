package com.bida.finalproject.riaautos.repository;

import com.bida.finalproject.riaautos.domain.SearchForEmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SearchForEmailNotificationRepository extends JpaRepository<SearchForEmailNotification, Long> {

    void deleteByUsername(String username);

    SearchForEmailNotification findByUsername(String username);
}
