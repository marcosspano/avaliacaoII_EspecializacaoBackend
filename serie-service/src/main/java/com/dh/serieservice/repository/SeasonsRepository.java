package com.dh.serieservice.repository;

import com.dh.serieservice.model.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonsRepository extends JpaRepository<Seasons, String> {



}
