package com.comeon.gamelove.repository;

import com.comeon.gamelove.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
