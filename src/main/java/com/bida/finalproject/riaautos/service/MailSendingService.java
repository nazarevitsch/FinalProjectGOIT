package com.bida.finalproject.riaautos.service;


import com.bida.finalproject.riaautos.domain.Auto;
import com.bida.finalproject.riaautos.domain.SearchForEmailNotification;
import com.bida.finalproject.riaautos.mailsender.EmailServiceImpl;
import com.bida.finalproject.riaautos.repository.SearchForEmailNotificationRepository;
import com.bida.finalproject.riaautos.request.JSONParser;
import com.bida.finalproject.riaautos.request.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MailSendingService {


    @Autowired
    private SearchForEmailNotificationRepository searchForEmailNotificationRepository;

    @Autowired
    private AutoService autoService;

    @Autowired
    private EmailServiceImpl emailService;

    @Scheduled(cron = "0 10 23 * * ?")
    public void sendingEmails(){
        Request request = new Request();
        List<SearchForEmailNotification> searches = searchForEmailNotificationRepository.findAll();
        for (int i = 0; i < searches.size(); i++) {
            String linkWithIDS = request.searchRequest(searches.get(i).getLink(), 0);
            List<String> list = JSONParser.parseSearchResult(linkWithIDS);
            int count = JSONParser.parseAndFindCount(linkWithIDS);
            count = count % 10 > 0 ? (count / 10) + 1 : (count / 10);
            for (int l = 1; l < count; l++) {
                list.addAll(JSONParser.parseSearchResult(request.searchRequest(searches.get(i).getLink(), l)));
            }
            List<Auto> autos = autoService.createAutosFromLinks(list);
            emailService.sendEmail(searches.get(i).getUsername(), "New Cars", autoService.createTextForEmailFromAutos(autos));
        }
        log.info("All Massages were sent in " + (new Date()) + " !");
    }
}
