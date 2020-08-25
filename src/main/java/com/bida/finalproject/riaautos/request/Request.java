package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Request {

    Logger logger = LoggerFactory.getLogger(Request.class);

    public String generateURI(Search search, int page) {
        String uri = "https://developers.ria.com/auto/search?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        if (search.getCategoryID() != -1){
         uri = uri + "&category_id=" + search.getCategoryID();
        }
        if (search.getBodyStyleID() != -1){
            uri = uri + "&bodystyle[0]=" + search.getBodyStyleID();
        }
        if (search.getMarkID() != -1){
            uri = uri + "&marka_id[0]=" + search.getMarkID();
        }
        if (search.getModelID() != -1){
            uri = uri + "&model_id[0]=" + search.getModelID();
        }
        if (search.getRegionID() != -1) {
            uri = uri + "&state[0]=" + search.getRegionID() + "&city[0]=0";
        }
        if (search.getColorID() != -1) {
            uri = uri + "&color[0]=" + search.getColorID();
        }
        if (search.getGearBoxID() != -1) {
            uri = uri + "&gearbox[0]=" + search.getGearBoxID();
        }
        if (search.getFuelTypeID() != -1) {
            uri = uri + "&type[0]=" + search.getFuelTypeID();
        }
        if (search.getPriceFrom() != 0) {
            uri = uri + "&price_ot=" + search.getPriceFrom();
        }
        if (search.getPriceTo() != 0) {
            uri = uri + "&price_do=" + search.getPriceTo();
        }
        if (page != -1) {
            uri = uri + "&page=" + page;
        }
        return uri;
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
        String uri = "http://api.auto.ria.com/categories/" + categoryID + "/marks/" + markID + "/models?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        return getRequest(uri);
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
            logger.error("ERROR with Request!!!");
        }
        return null;
    }
}
