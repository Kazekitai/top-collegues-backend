package com.example.topcolleguesbackend.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.example.topcolleguesbackend.service.InitialiserListeColleguesServiceDev;


/**
 * Ecouteur pour initialiser les données dans la base au lancement de
 * l'application
 * 
 * @author Sandra Le Thiec
 *
 */
@Component
public class InitialiserDonneesListener {
	/* ATTRIBUTS */
	/**
	 * Service d'initialisation des données dans la base
	 */
	@Autowired	private InitialiserListeColleguesServiceDev initialiserColleguesServiceDev;
	
	/* METHODES */

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		initialiserColleguesServiceDev.initialiser();
	}

}
