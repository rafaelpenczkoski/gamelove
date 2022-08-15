package com.comeon.gamelove.repository;

import com.comeon.gamelove.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
