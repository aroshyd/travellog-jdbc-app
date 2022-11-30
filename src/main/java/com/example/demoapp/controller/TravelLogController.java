package com.example.demoapp.controller;


import com.example.demoapp.entity.TravelLog;
import com.example.demoapp.entity.constant.RestConstants;
import com.example.demoapp.payload.FilterDto;
import com.example.demoapp.payload.TravelLogCreateDto;
import com.example.demoapp.payload.TravelLogDto;
import com.example.demoapp.response.DataDto;
import com.example.demoapp.service.ITravelLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = TravelLogController.PRODUCT_CONTROLLER_PATH)
@RequiredArgsConstructor
public class TravelLogController {

    public static final String PRODUCT_CONTROLLER_PATH= RestConstants.BASE_PATH_V1+RestConstants.TRAVEL_LOG_PATH;

    private final ITravelLogService travelLogService;


    @PostMapping("/report")
    public ResponseEntity<DataDto<List<TravelLogDto>>> report(@RequestBody(required = false) FilterDto filterDto) {
        return travelLogService.report(filterDto);
    }

    @PostMapping("/create")
    public ResponseEntity<DataDto<TravelLogDto>> create(@RequestBody TravelLogCreateDto travelLogDto){
        return travelLogService.create(travelLogDto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DataDto<TravelLogDto>> update(@RequestBody TravelLogCreateDto travelLogDto, @PathVariable(value = "id") Long id){
        return travelLogService.update(travelLogDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DataDto<Boolean>> delete(@PathVariable(value = "id") Long id){
        return travelLogService.delete(id);
    }

}
