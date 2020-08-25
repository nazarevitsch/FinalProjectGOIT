package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.Search;
import com.bida.finalproject.riaautos.domain.SearchForEmailNotification;
import com.bida.finalproject.riaautos.repository.SearchForEmailNotificationRepository;
import com.bida.finalproject.riaautos.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchForEmailNotificationService {

    @Autowired
    private SearchForEmailNotificationRepository searchForEmailNotificationRepository;

    public void save(Search search){
        Request request = new Request();
        SearchForEmailNotification searchForEmailNotification = new SearchForEmailNotification();
        searchForEmailNotification.setUsername(search.getUsername());
        searchForEmailNotification.setLink(request.generateURI(search, -1) + "&top=11");
        searchForEmailNotificationRepository.saveAndFlush(searchForEmailNotification);
    }

    public void delete(String username){
        searchForEmailNotificationRepository.deleteByUsername(username);
    }

    public SearchForEmailNotification findByUsername(String username){
        return searchForEmailNotificationRepository.findByUsername(username);
    }
}
