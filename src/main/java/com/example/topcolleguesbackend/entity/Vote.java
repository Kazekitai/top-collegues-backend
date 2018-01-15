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
* Un Vote
* @author Sandra Le Thiec
*
*/
@Entity
@Table(name="VOTE")
public class Vote {
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
	 * Un avis
	 */
	@Column(name="AVIS")
	private String avis;
	
	/* CONSTRUCTEUR */
	/**
	 * Default constructor
	 */
	public Vote() {
		
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
	 * @return the avis
	 */
	public String getAvis() {
		return avis;
	}

	/**
	 * @param avis the avis to set
	 */
	public void setAvis(String avis) {
		this.avis = avis;
	}
	
	

}
