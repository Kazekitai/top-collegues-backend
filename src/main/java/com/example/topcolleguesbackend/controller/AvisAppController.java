package com.example.topcolleguesbackend.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.topcolleguesbackend.entity.AvisApp;
import com.example.topcolleguesbackend.repository.AvisAppRepository;

/**
 * Controller pour l'api Avis App
 * @author Sandra Le Thiec
 *
 */
@RestController
@RequestMapping("/avis")
public class AvisAppController {
	@Autowired private AvisAppRepository avisAppRepository;
	
	@GetMapping
	public List<AvisApp> listerCommentaires() {
		return this.avisAppRepository.findAll();
	}
	
	@PostMapping("/creer")
	public @ResponseBody HashMap<String,Object> ajouterAvisApp(@RequestBody AvisApp avis) {
		AvisApp newAvis = new AvisApp();
		String message = "";
		String succes = "false";
		//Tester si la taille du commentaire est valide.
		if(avis.getMessage() != "") {
			// message non vide on verifie que le collègue a bien été récupéré
			if(avis.getMessage().length() > 255 ) {
				message = "Veuillez saisir moins de 255 caractères";
			}else if(avis.getMessage().length() < 20 ) {
				message = "Veuillez saisir au moins 20 caractères";
			}  else {
				newAvis.setMessage(avis.getMessage());
				newAvis.setMention(avis.getMention());
				avisAppRepository.save(newAvis);
				succes = "true";
				message = "L'avis a été ajouté avec succès";
			}
			
		} else {
			// message vide on n'enregistre pas
			message = "Champ vide. Veuillez saisir votre commentaire";
		}
		
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("succes", succes);
		result.put("message", message);
		result.put("entite", newAvis);
		

		return result;
	}

}
