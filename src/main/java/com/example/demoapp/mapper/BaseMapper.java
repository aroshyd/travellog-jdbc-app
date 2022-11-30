package com.example.demoapp.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @param <E>  - Entity
 * @param <D>  - Dto
 * @param <CD>  - CreateDto
 */

public interface BaseMapper<E,D,CD> {

    D toDto(E entity);


    E fromCreateDto(CD createDto);

    E fromDto(D dto);

    void fromUpdateDto(CD updateDto, @MappingTarget E entity);

    List<D> toDtoList(List<E> entityList);
    List<E> fromDto(List<D> dtoList);





}
