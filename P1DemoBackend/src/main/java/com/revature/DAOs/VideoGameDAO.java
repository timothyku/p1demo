package com.revature.DAOs;

import com.revature.models.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Make this Interface a bea
public interface VideoGameDAO extends JpaRepository<VideoGame, Integer> {

}
