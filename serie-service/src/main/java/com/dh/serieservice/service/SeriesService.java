package com.dh.serieservice.service;

import com.dh.serieservice.model.Chapters;
import com.dh.serieservice.model.Seasons;
import com.dh.serieservice.model.Series;
import com.dh.serieservice.repository.ChaptersRepository;
import com.dh.serieservice.repository.SeasonsRepository;
import com.dh.serieservice.repository.SeriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SeriesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonsRepository seasonsRepository;

    @Autowired
    private ChaptersRepository chaptersRepository;

    @Autowired
    private ModelMapper modelMapper;
    private Object Series;

    public List<Series> listarSeriesPorGenero(String genre) {
        List<Series> series = seriesRepository.findAllByGenreContains(genre);
        return (List<com.dh.serieservice.model.Series>) series.stream().map(series1 -> modelMapper.map(series, Series.class));
    }

    public Series adicionarSerie(Series series) {
        log.info(restTemplate.getForObject("http://serie-service:8085/series/", String.class));
        Series seriesModel = modelMapper.map(Series, Series.class);

        Set<Seasons> seasonsSet = series.getSeasons().stream().map(seasons -> {
            Seasons seasonsModel = modelMapper.map(seasons, Seasons.class);
            Set<Chapters> chaptersSet = seasons.getChapters().stream().map(chapters -> {
                Chapters chaptersModel = modelMapper.map(chapters, Chapters.class);
                return chaptersRepository.save(chaptersModel);
            }).collect(Collectors.toSet());
            seasonsModel.setChapters(chaptersSet);
            return seasonsRepository.save(seasonsModel);
        }).collect(Collectors.toSet());
        seriesModel.setSeasons(seasonsSet);
        Series seriesBase = seriesRepository.save(seriesModel);
        return modelMapper.map(seriesBase, Series.class);
    }

}
