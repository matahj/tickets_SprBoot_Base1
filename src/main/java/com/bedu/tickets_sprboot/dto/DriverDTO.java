package com.bedu.tickets_sprboot.dto;

import lombok.Data;

@Data
public class DriverDTO {
    private long id;
    private String name;
    private String phone;
    private String address;
    private StationDTO station;
}
