package com.example.topcolleguesbackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.topcolleguesbackend.entity.Collegue;
import com.example.topcolleguesbackend.repository.ColleguesRepository;


/**
 * Controller pour l'api Collegue
 * @author Sandra Le Thiec
 *
 */
@RestController
@RequestMapping("/collegues")
public class ColleguesController {
	@Autowired private ColleguesRepository colleguesRepository;
	
	@GetMapping
	public List<Collegue> listercollaborateurs() {
		return this.colleguesRepository.findAll();
	}
	
	@PostMapping("/creer")
	public @ResponseBody Collegue ajouterCollegue(@RequestBody Collegue collegue) {
		Collegue nouveauCollege = new Collegue();
		nouveauCollege.setPseudo(collegue.getPseudo());
		nouveauCollege.setImageUrl(collegue.getImageUrl());
		nouveauCollege.setScore(0);
		colleguesRepository.save(nouveauCollege);

		return nouveauCollege;
	}
	

}
