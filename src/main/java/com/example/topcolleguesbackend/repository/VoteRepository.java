package com.example.topcolleguesbackend.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.topcolleguesbackend.entity.Vote;

/**
 * Repository pour l'entité Vote
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface VoteRepository extends JpaRepository<Vote, Integer>{

}
