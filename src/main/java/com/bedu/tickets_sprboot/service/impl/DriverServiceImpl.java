package com.bedu.tickets_sprboot.service.impl;

import com.bedu.tickets_sprboot.dto.DriverDTO;
import com.bedu.tickets_sprboot.entity.Driver;
import com.bedu.tickets_sprboot.mapper.DriverMapper;
import com.bedu.tickets_sprboot.mapper.StationMapper;
import com.bedu.tickets_sprboot.repository.DriverRepository;
import com.bedu.tickets_sprboot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverMapper mapper;
    private DriverRepository repository;
    private StationMapper stationMapper;

    @Autowired
    public DriverServiceImpl(DriverMapper mapper, DriverRepository repository, StationMapper stationMapper){
        this.mapper = mapper;
        this.repository = repository;
        this.stationMapper = stationMapper;
    }

    @Override
    public DriverDTO save(DriverDTO data) {
        Driver entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public List<DriverDTO> findAll() {
        List<Driver> drivers = repository.findAll();

        //Versión funcional
        //return drivers.stream().map(mapper::toDTO).toList();

        //Versión imperativa
        List<DriverDTO> mappedDrivers = new LinkedList<>();
        for(Driver d: drivers){
            mappedDrivers.add(mapper.toDTO(d));
        }
        return mappedDrivers;
    }

    @Override
    public DriverDTO findById(long id) throws Exception{
        Optional<Driver> result = repository.findById(id);

        if(result.isEmpty()){
            throw new Exception("The driver doesn't exist.");
        }

        return mapper.toDTO(result.get());
    }

    @Override
    public void update(long id, DriverDTO data) throws Exception {

        Optional<Driver> result = repository.findById(id);

        if(result.isEmpty()){
            throw new Exception("The driver doesn't exist.");
        }

        Driver driver = result.get();

        driver.setName(data.getName());
        driver.setPhone(data.getPhone());
        driver.setAddress(data.getAddress());
        driver.setStation( stationMapper.toEntity(data.getStation()));

        repository.save(driver);
    }

    @Override
    public void delete(long id) throws Exception {
        Optional<Driver> result = repository.findById(id);

        if(result.isEmpty()){
            throw new Exception("The driver doesn't exist.");
        }

        repository.deleteById(id);
    }
}
