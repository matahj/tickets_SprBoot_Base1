package com.bedu.tickets_sprboot.controller;

import com.bedu.tickets_sprboot.dto.DriverDTO;
import com.bedu.tickets_sprboot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private DriverService service;

    @Autowired
    public DriverController(DriverService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO save(@RequestBody DriverDTO data){
        return service.save(data);
    }

    @GetMapping
    public List<DriverDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DriverDTO findById(@PathVariable("id") long id) throws Exception {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody DriverDTO data) throws Exception{
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
    }

}
