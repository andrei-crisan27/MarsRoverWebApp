package com.marsrover;

import marsrover.response.MarsPhoto;
import marsrover.response.MarsRoverApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import marsrover.service.MarsRoverApiService;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverAPITest {

    private MarsRoverApiService roverService;
    @Test
    public void smallTest() {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY", MarsRoverApiResponse.class);
        MarsRoverApiResponse roverData = response.getBody();
        //MarsRoverApiResponse roverData = roverService.getRoverData();
        List<String> imageUrls = new ArrayList<>();
        List<MarsPhoto> allPhotos = roverData.getPhotos();
        for(MarsPhoto p : allPhotos)
            imageUrls.add(p.getImgSrc());
        String image1 = imageUrls.get(0);
        System.out.println(image1);
    }
}
