package com.bida.finalproject.riaautos.request;

import com.bida.finalproject.riaautos.domain.BodyStyle;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Request {

    public String searchRequest(long categoryID, long bodyStyleID, long markID, long modelID, long regionID, long colorID, long gearBoxID, long typeFuelID, int priceFrom, int priceTo, int page){
        String uri = "https://developers.ria.com/auto/search?api_key=joHGTFk0MJ94jlb9EFbySvyheUMzTw4PcYuIE6vz";
        uri = uri + "&category_id=" + categoryID + "&bodystyle[0]=" + bodyStyleID + "&marka_id[0]=" + markID + "&model_id[0]=" + modelID;
        if (regionID != -1){
            uri = uri + "&state[0]=" + regionID + "&city[0]=0";
        }//"result":{"search_result":{"ids":["27719768","27651891","27183875","26565633","27555364","27617697","27419990","27352383","27223113","24357099"]
        if (colorID != -1){
            uri = uri + "&color[0]=" + colorID;
        }
        if (gearBoxID != -1){
            uri = uri + "&gearbox[0]=" + gearBoxID;
        }
        if (typeFuelID != -1){
            uri = uri + "&type[0]=" + typeFuelID;
        }
        if (priceFrom != 0){
            uri = uri + "&price_ot=" + priceFrom;
        }
        if (priceTo != 0){
            uri = uri + "&price_do=" + priceTo;
        }
        if (page != 0){
            uri = uri + "&page=" + page;
        }
        return getRequest(uri);
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
            System.out.println("ERROR...");
        }
        return null;
    }
}
