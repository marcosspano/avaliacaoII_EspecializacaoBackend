package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Series implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic (fetch = FetchType.LAZY)
    private String name;

    @Basic (fetch = FetchType.LAZY)
    private String genre;

    private Set<Seasons> seasons = new HashSet<>();

}
