package com.example.mission.controller;

import com.example.mission.model.dto.LatestTrailersDto;
import com.example.mission.service.TrailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/trailers")
public class TrailerController {
    private final TrailerService trailerService;
    //최신 예고편 API
    @GetMapping
    public LatestTrailersDto getLatestTrailerDto(){
        var res =trailerService.getLatestTrailers();
        return res;
    }
}
