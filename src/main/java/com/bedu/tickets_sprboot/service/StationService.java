package com.bedu.tickets_sprboot.service;

import com.bedu.tickets_sprboot.dto.StationDTO;

import java.util.List;
import java.util.Optional;

public interface StationService {
    //Operaciones CRUD: create, read, update, delete.

    StationDTO save(StationDTO data);

    List<StationDTO> findAll();
    StationDTO findById(long id) throws Exception;

    void update(long id, StationDTO data) throws Exception;

    void delete(long id) throws Exception;
}
