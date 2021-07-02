package main.Topic;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class CovidService {

    private static final Gson GSON = new Gson();

    public String getCovidResponse() throws IOException, InterruptedException {
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=560069&date=17-06-2021";
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36")
                .uri(URI.create(url)).build();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        return GSON.toJson(httpResponse.body());
    }

    public String getCovidResponse(String pincode, String date) throws IOException, InterruptedException {
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="+pincode+"&date="+date;
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36")
                .uri(URI.create(url)).build();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        return GSON.toJson(httpResponse.body());
    }

}