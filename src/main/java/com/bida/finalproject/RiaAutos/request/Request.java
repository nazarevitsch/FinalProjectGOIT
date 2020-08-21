package com.bida.finalproject.RiaAutos.request;

import com.bida.finalproject.RiaAutos.domain.BodyStyle;
import com.bida.finalproject.RiaAutos.domain.Model;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class Request {


    public void getAllAutoCategories() throws Exception{
        String uri = "https://developers.ria.com/auto/categories/?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        System.out.println(getRequest(uri));
    }

    public void getAllBodyStylesByCategoryID(long id){
        String uri = "https://developers.ria.com/auto/categories/" + id + "/bodystyles?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        System.out.println(getRequest(uri));
    }

    public void getAllMarksByCategoryID(long id) throws Exception{
        String uri = "http://api.auto.ria.com/categories/" + id + "/marks?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        System.out.println(getRequest(uri));
    }

    public void search(){
        String uri = "https://developers.ria.com/auto/search?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz&category_id=1&" + BodyStyle.CABRIOLET.getValue();
        System.out.println(getRequest(uri));
    }

    private String getRequest(String uri){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .timeout(Duration.ofMinutes(1))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().toString();
        } catch (Exception e){
            System.out.println("ERROR...");
        }
        return null;
    }
}
