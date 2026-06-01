package ro.skincare.skincare_analyzer.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

@Service
public class OpenBeautyFactsClient {
    private RestTemplate restTemplate;

    public OpenBeautyFactsClient(){
        this.restTemplate=new RestTemplate();
    }

    public Map<String, String> scanBarcode(String barcode){
        String url = "https://world.openbeautyfacts.org/api/v2/product/" + barcode + ".json";
        JsonNode root = restTemplate.getForObject(url, JsonNode.class);
        Map<String, String> rezultat = new HashMap<>();
        rezultat.put("productName",root.path("product").path("product_name").asText());
        rezultat.put("ingredientsText", root.path("product").path("ingredients_text").asText());
        return rezultat;
    }
}
