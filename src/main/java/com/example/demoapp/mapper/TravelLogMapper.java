package com.example.demoapp.mapper;


import com.example.demoapp.entity.TravelLog;
import com.example.demoapp.payload.TravelLogCreateDto;
import com.example.demoapp.payload.TravelLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE,componentModel = "spring")
@Component
public interface TravelLogMapper extends BaseMapper<TravelLog, TravelLogDto, TravelLogCreateDto>{

}
