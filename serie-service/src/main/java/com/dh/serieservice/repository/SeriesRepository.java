package com.dh.serieservice.repository;

import com.dh.serieservice.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series, String> {

    List<Series> findAllByGenreContains(String genre);

}
