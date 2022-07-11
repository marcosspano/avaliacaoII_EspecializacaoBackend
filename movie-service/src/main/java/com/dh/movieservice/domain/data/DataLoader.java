package com.dh.movieservice.domain.data;

import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private MovieRepository repository;

    public DataLoader (MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run (ApplicationArguments args) throws Exception {
        repository.save(new Movie(1L, "A volta dos que não foram", "Suspense", "What"));
        repository.save(new Movie(2L, "Chuck", "Terror", "What"));
        repository.save(new Movie(3L, "Morte no funeral", "Comédia", "What"));
        repository.save(new Movie(4L, "O melhor amigo da noiva", "Comédia", "What"));
        repository.save(new Movie(5L, "BadBoys", "Ação", "What"));
    }

}
