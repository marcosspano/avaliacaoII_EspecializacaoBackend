package com.dh.catalogservice.queue;

import com.dh.catalogservice.domain.model.Movie;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue movieQueue;

    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), movie);
    }

}
