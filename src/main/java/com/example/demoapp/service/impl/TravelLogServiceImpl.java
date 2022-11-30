package com.example.demoapp.service.impl;

import com.example.demoapp.entity.TravelLog;
import com.example.demoapp.entity.constant.RestConstants;
import com.example.demoapp.exception.ValidationException;
import com.example.demoapp.mapper.TravelLogMapper;
import com.example.demoapp.payload.FilterDto;
import com.example.demoapp.payload.TravelLogCreateDto;
import com.example.demoapp.payload.TravelLogDto;
import com.example.demoapp.repository.TravelLogRepository;
import com.example.demoapp.response.DataDto;
import com.example.demoapp.service.GenericCrudService;
import com.example.demoapp.service.ITravelLogService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TravelLogServiceImpl extends GenericCrudService implements ITravelLogService {

    private final Log logger = LogFactory.getLog(getClass());
    private final TravelLogRepository travelLogRepository;

    private final TravelLogMapper travelLogMapper;


    @Override
    public ResponseEntity<DataDto<List<TravelLogDto>>> report(FilterDto filterDto) {
        long totalTraveledDistance;
        List<TravelLog> travelLogList = travelLogRepository.findByFilter(filterDto);
        totalTraveledDistance= getTotalTraveledDistance(travelLogList);
        return new ResponseEntity<>(new DataDto<>(travelLogMapper.toDtoList(travelLogList),totalTraveledDistance),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<TravelLogDto>> create(TravelLogCreateDto travelLogCreateDto){
        TravelLog travelLog = travelLogMapper.fromCreateDto(travelLogCreateDto);
        travelLogRepository.save(travelLog);
        return new ResponseEntity<>(new DataDto<>(travelLogMapper.toDto(travelLog)),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DataDto<TravelLogDto>> update(TravelLogCreateDto travelLogCreateDto, Long id){
        validate(id);
        Optional<TravelLog> optionalTravelLog = travelLogRepository.findById(id);
        TravelLog travelLog = optionalTravelLog.get();
        travelLogMapper.fromUpdateDto(travelLogCreateDto, travelLog);
        travelLogRepository.update(travelLog);
        return new ResponseEntity<>(new DataDto<>(travelLogMapper.toDto(travelLog)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<Boolean>> delete(Long id){
        validate(id);
        travelLogRepository.deleteById(id);
        return new ResponseEntity<>(new DataDto<>(true),HttpStatus.OK);
    }

    @Override
    public void validate(Long id){
        Optional<TravelLog> optionalTravelLog = travelLogRepository.findById(id);
        if (optionalTravelLog.isEmpty()){
            logger.error(String.format("TravelLog with id '%s' not found", id));
            throw new ValidationException(RestConstants.TRAVEL_LOG_NOT_FOUND_ID);
        }
    }

    public long getTotalTraveledDistance(List<TravelLog> travelLogList){
        return travelLogList.stream()
                .mapToLong(value -> (value.getOdometerEnd() - value.getOdometerBegin()))
                .sum();
    }



}
