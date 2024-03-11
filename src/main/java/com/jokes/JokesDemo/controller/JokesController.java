package com.jokes.JokesDemo.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jokes.JokesDemo.entity.Joke;
import com.jokes.JokesDemo.repository.JokeRepository;
import com.jokes.JokesDemo.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class JokesController {

    private final JokeService jokeService;
    @Autowired
    private JokeRepository jokeRepository;
    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
    @GetMapping("/jokes")
    public ResponseEntity<?> getJokes(@RequestParam(defaultValue = "5") int count) throws JsonProcessingException {
        if (count < 1 || count > 100) {
            return ResponseEntity.badRequest().body("You can get no more than 100 jokes at a time");
        }
        List<String> jokes = jokeService.getJokes(count);
        ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(jokes);
        return ResponseEntity.ok(jsonString);
    }
}