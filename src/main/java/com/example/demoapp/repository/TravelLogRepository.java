package com.example.demoapp.repository;

import com.example.demoapp.entity.TravelLog;
import com.example.demoapp.payload.FilterDto;
import java.util.List;
import java.util.Optional;



public interface TravelLogRepository  {

    int save(TravelLog travelLog);

    int update(TravelLog travelLog);

    int deleteById(Long id);

    Optional<TravelLog> findById(Long id);

    List<TravelLog> findByFilter(FilterDto filterDto);





}
