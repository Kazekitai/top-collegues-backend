package com.example.topcolleguesbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Un Collègue
* @author Sandra Le Thiec
*
*/
@Entity
@Table(name="COLLEGUE")
public class Collegue {
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant de base
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	/**
	 * Un score
	 */
	@Column(name="SCORE")
	private int score;
	
	/**
	 * Un pseudo
	 */
	@Column(name="PSEUDO")
	private String pseudo;
	
	/**
	 * Un url d'image
	 */
	@Column(name="IMAGE_URL")
	private String imageUrl;
	
	/* CONSTRUCTEUR */
	/**
	 * Default constructor
	 */
	public Collegue() {
		
	}
	
	/* ACCESSEURS */

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
