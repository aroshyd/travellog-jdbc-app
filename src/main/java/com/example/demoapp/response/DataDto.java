package com.example.demoapp.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DataDto<T> implements Serializable {

    protected T data;

    protected ErrorDto error;

    protected long totalTraveledDistance;

    protected boolean success;

    public DataDto(boolean success) {
        this.success = success;
    }

    public DataDto(T data) {
        this.data = data;
        this.success = true;
    }

    public DataDto(T data, long totalTraveledDistance) {
        this.data = data;
        this.totalTraveledDistance =totalTraveledDistance;
        this.success = true;

    }

    public DataDto(ErrorDto error) {
        this.error = error;
        this.success = false;
    }
}
