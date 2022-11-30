package com.example.demoapp.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TravelLogDto {

    private Long id;

    private LocalDate date;

    private String vehicleRegNumber;

    private String vehicleOwnerName;

    private Long odometerBegin;

    private Long odometerEnd;

    private String route;

    private String journeyDescription;

}
