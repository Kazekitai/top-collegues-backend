package com.example.topcolleguesbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.topcolleguesbackend.entity.Collegue;
import com.example.topcolleguesbackend.repository.ColleguesRepository;

/**
 * Service d'initialisation des collegues
 * @author Sandra Le Thiec
 *
 */
@Component
public class InitialiserListeColleguesServiceDev implements InitialiserDonneesService  {

	@Autowired private ColleguesRepository colleguesRepository;
	
	@Override
	public void initialiser() {
		Collegue col1 = new Collegue();
		col1.setPseudo("Hermione");
		col1.setImageUrl("https://img.buzzfeed.com/buzzfeed-static/static/2014-04/tmp/webdr02/2/17/0e7cd6da3ce720d983515a9ab831a530-3.jpg?downsize=715:*&output-format=auto&output-quality=auto");
		col1.setScore(0);
		
		Collegue col2 = new Collegue();
		col2.setPseudo("Ron");
		col2.setImageUrl("https://www.quizz.biz/uploads/quizz/687335/orig/1.jpg?1479691894");
		col2.setScore(0);
		
		Collegue col3 = new Collegue();
		col3.setPseudo("Harry");
		col3.setImageUrl("http://www.jdubuzz.com/files/2016/09/deux-ans-plus-tard-le-revoila-dans-harry-potter-et-la-chambre-des-secrets-il-n-a-presque-pas-bouge.jpg");
		col3.setScore(0);
		
		colleguesRepository.save(col1);
		colleguesRepository.save(col2);
		colleguesRepository.save(col3);
	}

}
