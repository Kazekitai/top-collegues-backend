package com.example.topcolleguesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.topcolleguesbackend.entity.AvisApp;

/**
 * Interface repository pour les avis sur l'application
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
@Transactional
public interface AvisAppRepository extends JpaRepository<AvisApp, Integer>{

}
