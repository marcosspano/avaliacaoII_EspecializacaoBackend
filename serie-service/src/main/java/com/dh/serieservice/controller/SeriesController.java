package com.dh.serieservice.controller;

import com.dh.serieservice.config.RabbitMQSenderConfig;
import com.dh.serieservice.model.Series;
import com.dh.serieservice.service.SeriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    @GetMapping("{genre}")
    public List<Series> listarSeriesPorGenero(@PathVariable(value = "genre") String genre) {
        return seriesService.listarSeriesPorGenero(genre);
    }

    @PostMapping
    public ResponseEntity<?> adicionarSerie(@RequestBody Series serie) {
        Series series = seriesService.adicionarSerie(serie);
        rabbitMQSenderConfig.convertAndSendSeries(series);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
