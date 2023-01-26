package com.bedu.tickets_sprboot.repository;

import com.bedu.tickets_sprboot.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
