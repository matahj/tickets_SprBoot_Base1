package com.bedu.tickets_sprboot.service.impl;

import com.bedu.tickets_sprboot.dto.StationDTO;
import com.bedu.tickets_sprboot.entity.Station;
import com.bedu.tickets_sprboot.mapper.StationMapper;
import com.bedu.tickets_sprboot.repository.StationRepository;
import com.bedu.tickets_sprboot.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    private StationMapper mapper;
    private StationRepository repository;

    @Autowired
    public StationServiceImpl(StationMapper mapper, StationRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public StationDTO save(StationDTO data) {
        Station entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public List<StationDTO> findAll() {
        List<Station> stations = repository.findAll();

        //Versión funcional
        //return stations.stream().map(mapper::toDTO).toList();

        //Versión imperativa
        List<StationDTO> mappedStations = new LinkedList<>();
        for(Station s: stations){
            mappedStations.add(mapper.toDTO(s));
        }
        return mappedStations;
    }
    @Override
    public StationDTO findById(long id) throws Exception{
        Optional<Station> result = repository.findById(id);

        if(result.isEmpty()){
            throw new Exception("The station doesn't exist.");
        }

        return mapper.toDTO(result.get());
    }

    @Override
    public void update(long id, StationDTO data) throws Exception {
        Optional<Station> result = repository.findById(id);

        if(result.isEmpty()){
            throw new Exception("The station doesn't exist.");
        }

        Station station = result.get();

        station.setCity(data.getCity());
        station.setAddress(data.getAddress());

        repository.save(station);
    }

    @Override
    public void delete(long id) throws Exception {
        Optional<Station> result = repository.findById(id);

        if(result.isEmpty()){
            throw new Exception("The station doesn't exist.");
        }

        repository.deleteById(id);
    }
}
