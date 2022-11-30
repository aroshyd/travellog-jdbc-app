package com.example.demoapp.service;

import com.example.demoapp.entity.TravelLog;
import com.example.demoapp.payload.FilterDto;
import com.example.demoapp.payload.TravelLogCreateDto;
import com.example.demoapp.payload.TravelLogDto;
import com.example.demoapp.response.DataDto;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ITravelLogService {

    ResponseEntity<DataDto<List<TravelLogDto>>> report(FilterDto filterDto);

    ResponseEntity<DataDto<TravelLogDto>> create(TravelLogCreateDto travelLogDto);

    ResponseEntity<DataDto<TravelLogDto>> update(@NotNull TravelLogCreateDto travelLogCreateDto, Long id);

    public ResponseEntity<DataDto<Boolean>> delete(@NotNull Long id);

}
