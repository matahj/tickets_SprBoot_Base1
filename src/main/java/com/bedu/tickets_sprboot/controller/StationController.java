package com.bedu.tickets_sprboot.controller;

import com.bedu.tickets_sprboot.dto.StationDTO;
import com.bedu.tickets_sprboot.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    private StationService service;

    @Autowired
    public StationController(StationService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StationDTO save(@RequestBody StationDTO data){
        return service.save(data);
    }

    @GetMapping
    public List<StationDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StationDTO findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody StationDTO data) throws Exception{
        service.update(id,data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
    }

}
