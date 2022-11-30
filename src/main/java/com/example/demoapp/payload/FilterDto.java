package com.example.demoapp.payload;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FilterDto {

    LocalDate fromDate;

    LocalDate toDate;

    private String vehicleRegNumber;

    private String vehicleOwnerName;

    public boolean isNotNull(){
        return fromDate!=null||toDate!=null||vehicleOwnerName!=null||vehicleRegNumber!=null;
    }
    public boolean isDateNull(){
        return fromDate==null &&
               toDate==null;
    }

    public boolean isFromDateNull(){
        return fromDate==null;
    }

    public boolean isVehicleRegNumberNull(){
        return vehicleRegNumber==null;
    }

    public boolean isVehicleOwnerNameNull(){
        return vehicleOwnerName==null;
    }

}
