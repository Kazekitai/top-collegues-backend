package com.example.topcolleguesbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Un Avis sur l'application
* @author Sandra Le Thiec
*
*/
@Entity
@Table(name="AVIS_APP")
public class AvisApp {
	/* ATTRIBUTS */
	public enum MENTION {Mauvais, Bien, Excellent}
	
	/**
	 * Un identifiant de base
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Une mention
	 */
	@Enumerated(EnumType.STRING)
	private MENTION mention;
	
	/**
	 * Un message
	 */
	@Column(name="MESSAGE")
	private String message;
	
	/* CONSTRUCTEUR */
	/**
	 * Default constructor
	 */
	public AvisApp() {
		
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
	 * @return the mention
	 */
	public MENTION getMention() {
		return mention;
	}

	/**
	 * @param mention the mention to set
	 */
	public void setMention(MENTION mention) {
		this.mention = mention;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
