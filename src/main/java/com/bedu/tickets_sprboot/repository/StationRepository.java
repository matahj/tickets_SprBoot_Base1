package com.bedu.tickets_sprboot.repository;

import com.bedu.tickets_sprboot.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
}
