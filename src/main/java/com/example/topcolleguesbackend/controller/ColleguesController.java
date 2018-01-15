package com.example.topcolleguesbackend.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.topcolleguesbackend.entity.Collegue;
import com.example.topcolleguesbackend.entity.Vote;
import com.example.topcolleguesbackend.repository.ColleguesRepository;
import com.example.topcolleguesbackend.repository.VoteRepository;

/**
 * Controller pour l'api Collegue
 * @author Sandra Le Thiec
 *
 */
@RestController
@RequestMapping("/collegues")
public class ColleguesController {
	@Autowired private ColleguesRepository colleguesRepository;
	@Autowired private VoteRepository voteRepository;
	
	@GetMapping
	public List<Collegue> listercollaborateurs() {
		return this.colleguesRepository.findAll();
	}
	
	@GetMapping("/{PSEUDO}")
	public List<Collegue> getCollaborateursByPseudo(@PathVariable("PSEUDO") String pseudo) {
		return this.colleguesRepository.findByPseudo(pseudo);
	}
	
	
	@PostMapping("/creer")
	public @ResponseBody HashMap<String,Object> ajouterCollegue(@RequestBody Collegue collegue) {
		Collegue nouveauCollege = new Collegue();
		String message = "";
		String succes = "false";
		//Tester si le collegue existe déjà. On ne le sauvegarde pas.
		List<Collegue> collegList = colleguesRepository.findByPseudo(collegue.getPseudo());
		if(!collegue.getPseudo().equals("") && !collegue.getImageUrl().equals("") ) {
			// Pseudo et image non vide
			if(collegList.size() > 0) {
				//Le collegue existe
				message = "Le collègue " + collegue.getPseudo() + " existe déjà !";
			} else {
				//Le collegue n'existe pas. On le sauvegarde.
				nouveauCollege.setPseudo(collegue.getPseudo());
				nouveauCollege.setImageUrl(collegue.getImageUrl());
				nouveauCollege.setScore(0);
				colleguesRepository.save(nouveauCollege);
				succes = "true";
				message = "Le collègue " + nouveauCollege.getPseudo() + " a été ajouté avec succès";
			}
		} else {
			// Pseudo et image vide ! On ne sauvegarde rien.
			message = "Tous les champs sont obligatoires !";
		}
		
		
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("succes", succes);
		result.put("message", message);
		result.put("entite", nouveauCollege);
		

		return result;
	}
	
	
	@PatchMapping("/{PSEUDO}")
	@ResponseBody Collegue modifierScoreCollegueParPseudo(@PathVariable("PSEUDO") String pseudo,
			@RequestBody HashMap<String,String> actionType) {
		Collegue collegbModif = colleguesRepository.findByPseudo(pseudo).get(0);
		int scoreInit = collegbModif.getScore();
		
		if(actionType.get("action").equals("aimer")) {
			collegbModif.setScore(scoreInit+10);
		} else if(actionType.get("action").equals("detester")) {
			collegbModif.setScore(scoreInit-5);
		}
		
		// Ajouter un vote dans l'historique des votes
		Vote vote = new Vote();
		vote.setAvis(actionType.get("action"));
		vote.setCollegue(collegbModif);
		this.voteRepository.save(vote);
		
		colleguesRepository.save(collegbModif);
	    return collegbModif;
	}
	

}
