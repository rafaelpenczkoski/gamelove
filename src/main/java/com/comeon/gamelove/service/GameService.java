package com.comeon.gamelove.service;

import com.comeon.gamelove.dto.GameDTO;
import com.comeon.gamelove.exception.GameNotFoundException;
import com.comeon.gamelove.model.Game;
import com.comeon.gamelove.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> getAllGames() {
        return repository.findAll();
    }

    public Game insertGame(Game game) {
        return repository.save(game);
    }

    public Game getGameById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    public List<GameDTO> getTopGames(Long limit) {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(game -> game.getPlayers().size(), Comparator.reverseOrder()))
                .limit(limit)
                .map(GameDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}
