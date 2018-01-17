package com.example.topcolleguesbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* Un Commentaire
* @author Sandra Le Thiec
*
*/
@Entity
@Table(name="COMMENTAIRE")
public class Commentaire {
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant de base
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Un collegue
	 */
	@ManyToOne
	@JoinColumn(name="COLLEGUE_ID")
	private Collegue collegue;
	
	/**
	 * Un commentaire
	 */
	@Column(name="COMMENTAIRE")
	private String commentaire;
	
	/* CONSTRUCTEUR */
	/**
	 * Default constructor
	 */
	public Commentaire() {
		
	}
	
	/* ACCESSEURS */

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * @param collegue the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	

}
