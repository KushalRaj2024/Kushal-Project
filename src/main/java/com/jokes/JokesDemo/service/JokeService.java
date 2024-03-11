package com.jokes.JokesDemo.service;
import com.jokes.JokesDemo.entity.Joke;
import com.jokes.JokesDemo.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


@Service
public class JokeService {
    @Autowired
    private JokeRepository jokeRepository;
   public List<String> getJokes(int count) {
       List<String> jokes = new ArrayList<>();
       int batches = (int) Math.ceil((double) count / 10);
       ExecutorService executor = Executors.newFixedThreadPool(10);
       List<Future<List<String>>> futures = new ArrayList<>();

       for (int i = 0; i < batches; i++) {
           int batchSize = Math.min(10, count - (i * 10));
           futures.add(executor.submit(() -> fetchJokes(batchSize)));
       }

       for (Future<List<String>> future : futures) {
           try {
               jokes.addAll(future.get());
           } catch (InterruptedException | ExecutionException e) {
           }
       }

       executor.shutdown();

       return jokes;
   }

    private List<String> fetchJokes(int count) {

        List<Joke> jokelist=jokeRepository.findAll();
        List<String> stringList = jokelist.stream()
                .map(Joke::toString)
                .collect(Collectors.toList());
        return  stringList;
    }
}
