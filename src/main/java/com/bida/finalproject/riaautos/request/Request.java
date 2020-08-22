package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.BodyStyle;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Request {


    public String getAllAutoCategories() throws Exception{
        String uri = "https://developers.ria.com/auto/categories/?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllBodyStylesByCategoryID(long id){
        String uri = "https://developers.ria.com/auto/categories/" + id + "/bodystyles?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllMarksByCategoryID(long id) throws Exception{
        String uri = "http://api.auto.ria.com/categories/" + id + "/marks?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllModelsByCategoryAndByModel(long categoryID, long markID){
        String uri = "http://api.auto.ria.com/categories/" + categoryID + "/marks/" + markID + "/models?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String search(){
        String uri = "https://developers.ria.com/auto/search?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz&category_id=1&" + BodyStyle.CABRIOLET.getValue();
        return getRequest(uri);
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
