package com.example.topcolleguesbackend.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.topcolleguesbackend.entity.Commentaire;
import com.example.topcolleguesbackend.repository.CommentaireRepository;

/**
 * Controller pour l'api commentaire
 * @author Sandra Le Thiec
 *
 */
@RestController
@RequestMapping("/commentaires")
public class CommentaireController {
	
	@Autowired private CommentaireRepository commentaireRepository;
	
	@GetMapping
	public List<Commentaire> listerCommentaires() {
		return this.commentaireRepository.findAll();
	}
	
	@GetMapping("/{idCollegue}")
	public List<Commentaire> getCommentairesParCollegue(@PathVariable("idCollegue") String collegue_id) {
		return this.commentaireRepository.findByCollegueId(collegue_id);	
	}
	
	@PostMapping("/creer")
	public @ResponseBody HashMap<String,Object> ajouterCommentaire(@RequestBody Commentaire commentaire) {
		Commentaire nouveauComment = new Commentaire();
		String message = "";
		String succes = "false";
		//Tester si la taille du commentaire est valide.
		if(commentaire.getCommentaire() != "") {
			// commentaire non vide on verifie que le collègue a bien été récupéré
			if(!commentaire.getCollegue().getId().equals("")) {
				// le collègue est récupéré on enregistre le commentaire
				if(commentaire.getCommentaire().length() > 255 ) {
					message = "Veuillez saisir moins de 255 caractères";
				} else {
					nouveauComment.setCollegue(commentaire.getCollegue());
					nouveauComment.setCommentaire(commentaire.getCommentaire());
					commentaireRepository.save(nouveauComment);
					succes = "true";
					message = "Le commentaire a été ajouté avec succès";
				}
			} else {
				// Le collègue concerné par le commentaire n'a pas été correctement récupéré
				message = "Le commentaire n'a pas pu être ajouté, le collègue n'est pas reconnu";				
			}
			
		} else {
			// commentaire vide on n'enregistre pas
			message = "Champ vide. Veuillez saisir votre commentaire";
		}
		
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("succes", succes);
		result.put("message", message);
		result.put("entite", nouveauComment);
		

		return result;
	}

}
