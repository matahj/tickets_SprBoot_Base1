package com.bedu.tickets_sprboot.mapper;

import com.bedu.tickets_sprboot.dto.StationDTO;
import com.bedu.tickets_sprboot.entity.Station;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StationMapper {
    StationDTO toDTO(Station data);
    Station toEntity(StationDTO data);
}
