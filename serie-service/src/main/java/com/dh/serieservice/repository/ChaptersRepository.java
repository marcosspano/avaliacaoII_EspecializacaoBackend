package com.dh.serieservice.repository;

import com.dh.serieservice.model.Chapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaptersRepository extends JpaRepository<Chapters, String> {



}
