package com.jokes.JokesDemo.repository;

import com.jokes.JokesDemo.entity.Joke;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JokeRepository extends MongoRepository<Joke, String> {
}
