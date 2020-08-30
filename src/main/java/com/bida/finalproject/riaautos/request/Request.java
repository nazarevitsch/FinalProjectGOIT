package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.Search;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Slf4j
public class Request {

    public String generateURI(Search search, int page) {
        StringBuilder builder = new StringBuilder();
        builder.append("https://developers.ria.com/auto/search?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz");
        if (search.getCategoryID() != -1){
            builder.append("&category_id=");
            builder.append(search.getCategoryID());
        }
        if (search.getBodyStyleID() != -1){
            builder.append("&bodystyle[0]=");
            builder.append(search.getBodyStyleID());
        }
        if (search.getMarkID() != -1){
            builder.append("&marka_id[0]=");
            builder.append(search.getMarkID());
        }
        if (search.getModelID() != -1){
            builder.append("&model_id[0]=");
            builder.append(search.getModelID());
        }
        if (search.getRegionID() != -1) {
            builder.append("&state[0]=");
            builder.append("&city[0]=0");
        }
        if (search.getColorID() != -1) {
            builder.append("&color[0]=");
            builder.append(search.getColorID());
        }
        if (search.getGearBoxID() != -1) {
            builder.append("&gearbox[0]=");
            builder.append(search.getGearBoxID());
        }
        if (search.getFuelTypeID() != -1) {
            builder.append("&type[0]=");
            builder.append(search.getFuelTypeID());
        }
        if (search.getPriceFrom() != 0) {
            builder.append("&price_ot=");
            builder.append(search.getPriceFrom());
        }
        if (search.getPriceTo() != 0) {
            builder.append("&price_do=");
            builder.append(search.getPriceTo());
        }
        if (page != -1) {
            builder.append("&page=");
            builder.append(page);
        }
        return builder.toString();
    }

    public String searchRequest(Search search, int page){
        String uri = generateURI(search, page);
        return getRequest(uri);
    }

    public String searchRequest(String link, int page){
        if (page != - 1) {
            link = link + "&page=" + page;
        }
        return getRequest(link);
    }

    public String getAllColors(){
        String uri = "https://developers.ria.com/auto/colors?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllRegions(){
        String uri = "https://developers.ria.com/auto/states?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllAutoCategories(){
        String uri = "https://developers.ria.com/auto/categories/?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllBodyStylesByCategoryID(long id){
        String uri = "https://developers.ria.com/auto/categories/" + id + "/bodystyles?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllMarksByCategoryID(long id){
        String uri = "http://api.auto.ria.com/categories/" + id + "/marks?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
    }

    public String getAllModelsByCategoryAndByModel(long categoryID, long markID){
        return getRequest(String.format("http://api.auto.ria.com/categories/%d/marks/%d/models?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz", categoryID, markID));
    }

    public String searchAutoByID(String id){
        String uri = "https://developers.ria.com/auto/info?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz&auto_id=" + id;
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
            return response.body();
        } catch (Exception e){
            log.error("ERROR with Request: {}", e.getMessage());
        }
        return null;
    }
}
