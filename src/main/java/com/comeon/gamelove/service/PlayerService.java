package com.comeon.gamelove.service;

import com.comeon.gamelove.exception.GameNotFoundException;
import com.comeon.gamelove.exception.PlayerNotFoundException;
import com.comeon.gamelove.model.Game;
import com.comeon.gamelove.model.Player;
import com.comeon.gamelove.repository.GameRepository;
import com.comeon.gamelove.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public PlayerService(PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    public Player insertPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Set<Game> getPlayerLovedGames(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId))
                .getLovedGames();
    }

    public Set<Game> loveGame(Long playerId, Long gameId) {
        Game dbGame = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException(gameId));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));

        player.getLovedGames().add(dbGame);
        playerRepository.save(player);
        return player.getLovedGames();
    }

    public Set<Game> unloveGame(Long playerId, Long gameId) {
        Game dbGame = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException(gameId));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));

        player.getLovedGames().remove(dbGame);
        playerRepository.save(player);
        return player.getLovedGames();
    }
}
