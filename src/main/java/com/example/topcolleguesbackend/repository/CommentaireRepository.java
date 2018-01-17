package com.example.topcolleguesbackend.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.topcolleguesbackend.entity.Commentaire;


/**
 * Repository pour l'entité Commentaire
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface CommentaireRepository extends JpaRepository<Commentaire, String> {
	List<Commentaire> findByCollegueId(String id);
	
}
