package main.tech.olatunbosun.termii;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ApiCall {

    private String url;
    private final HashMap<String, Object> queryMap;

    public ApiCall(String url, HashMap<String, Object> queryMap)  {
        this.url = url;
        this.queryMap = Objects.requireNonNullElseGet(queryMap, HashMap::new);
        ApiKey apiKey = new ApiKey();
        try {
            apiKey.initializeApiKey();
        } catch (FileNotFoundException e) {
            System.out.print("Required configKey.json file could not be found.");
            e.printStackTrace();
        }

        String apiKey1 = apiKey.getAPI_KEY();
        System.out.println(apiKey1);
        this.queryMap.put("api_key", apiKey1);
    }

    public JSONObject makePostRequest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            System.out.println(new JSONObject(getParams()));
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            StringEntity stringEntity = new StringEntity(new JSONObject(getParams()).toString());
            httpPost.setEntity(stringEntity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    return new JSONObject(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject makeGetRequest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String urlWithApiKey = url + "?api_key=" + queryMap.get("api_key");

            HttpGet httpGet = new HttpGet(urlWithApiKey);
            httpGet.setHeader("Accept", "application/json");

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    return new JSONObject(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void putParams(String key, Object value) {
        this.queryMap.put(key, value);
    }

    public HashMap<String, Object> getParams() {
        return this.queryMap;
    }
}