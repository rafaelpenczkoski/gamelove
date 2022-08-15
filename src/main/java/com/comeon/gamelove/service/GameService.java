package com.comeon.gamelove.service;

import com.comeon.gamelove.exception.GameNotFoundException;
import com.comeon.gamelove.model.Game;
import com.comeon.gamelove.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getAllGames() {
        return repository.findAll();
    }

    public Game getGameById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }
}
