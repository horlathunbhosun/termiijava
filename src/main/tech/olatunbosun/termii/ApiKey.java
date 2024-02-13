package main.tech.olatunbosun.termii;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ApiKey {

    private String API_KEY;

    void initializeApiKey() throws FileNotFoundException {
//        JSONObject apiKeyObject;
//        String fileData = "";
//        File file = new File("configKey.json");
//        Scanner scanner = new Scanner(file);
//
//        fileData = scanner.nextLine();
//        apiKeyObject = new JSONObject(fileData);
//
//        this.API_KEY = apiKeyObject.getString("API_KEY");


            File file = new File("configKey.json");
            Scanner scanner = new Scanner(file);
            StringBuilder fileData = new StringBuilder();

            while (scanner.hasNextLine()) {
                fileData.append(scanner.nextLine());
            }

            JSONObject apiKeyObject = new JSONObject(fileData.toString());
            this.API_KEY = apiKeyObject.getString("API_KEY");

            scanner.close();


    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    public void setAPI_KEY(String key) {
        this.API_KEY = key;
    }
}