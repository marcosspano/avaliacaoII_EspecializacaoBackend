package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long id;

    private String name;

    private String genre;

    private String urlStram;

}
