package com.bedu.tickets_sprboot.service;

import com.bedu.tickets_sprboot.dto.DriverDTO;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    //Operaciones CRUD: create, read, update, delete.

    DriverDTO save(DriverDTO data);

    List<DriverDTO> findAll();
    DriverDTO findById(long id) throws Exception;

    void update(long id, DriverDTO data) throws Exception;

    void delete(long id) throws Exception;
}
