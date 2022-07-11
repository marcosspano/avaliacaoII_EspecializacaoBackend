package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chapters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(fetch = FetchType.LAZY)
    private String name;

    @Basic(fetch = FetchType.LAZY)
    private Integer number;

    @Basic(fetch = FetchType.LAZY)
    private String urlStream;



}
