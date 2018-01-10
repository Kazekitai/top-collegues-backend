package com.example.topcolleguesbackend.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.topcolleguesbackend.entity.Collegue;

/**
 * Repository pour l'entité Collegue
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface ColleguesRepository extends JpaRepository<Collegue, Integer> {
	List<Collegue> findByPseudo(String pseudo);

}
