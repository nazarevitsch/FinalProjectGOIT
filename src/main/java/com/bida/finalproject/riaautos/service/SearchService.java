package com.bida.finalproject.riaautos.service;

import com.bida.finalproject.riaautos.domain.Search;
import com.bida.finalproject.riaautos.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public void save(Search search){
        searchRepository.save(search);
    }
}
