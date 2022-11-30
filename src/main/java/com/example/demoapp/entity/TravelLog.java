package com.example.demoapp.entity;


import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TravelLog {

    private Long id;

    private LocalDate date;//yyyy-MM-dd

    private String vehicleRegNumber;

    private String vehicleOwnerName;

    private Long odometerBegin;

    private Long odometerEnd;

    private String route;

    private String journeyDescription;

}
