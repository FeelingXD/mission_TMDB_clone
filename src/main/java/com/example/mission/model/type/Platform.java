package com.example.mission.model.type;

import lombok.AllArgsConstructor;


public enum Platform {
    TV,
    STREAMING,
    RENTAL,
    THEATER;
    public static Platform fromValue(String value){
        for (Platform platform:Platform.values()){
            if (platform.name().equalsIgnoreCase(value.trim())){
                return platform;
            }
        }
        throw new IllegalArgumentException("Invalid platform value" +value);
    }
}
