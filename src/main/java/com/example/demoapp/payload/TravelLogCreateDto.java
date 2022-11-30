package com.example.demoapp.payload;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class TravelLogCreateDto {

    private LocalDate date;

    private String vehicleRegNumber;

    private String vehicleOwnerName;

    private Long odometerBegin;

    private Long odometerEnd;

    private String route;

    private String journeyDescription;

}
