package com.bedu.tickets_sprboot.mapper;

import com.bedu.tickets_sprboot.dto.DriverDTO;
import com.bedu.tickets_sprboot.entity.Driver;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DriverMapper {
    DriverDTO toDTO(Driver data);
    Driver toEntity(DriverDTO data);
}
