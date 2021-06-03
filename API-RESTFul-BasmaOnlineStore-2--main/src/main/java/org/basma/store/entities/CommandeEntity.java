package org.basma.store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Commandes")
public class CommandeEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String commandeId;
	
	@Column
	private Double PrixTotalCommande;
	
	@Column
	private String addresseCommande;
	
	@Column
	private String ville;
	
	@Column
	private String descriptionCommande;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCommandeId() {
		return commandeId;
	}

	public void setCommandeId(String commandeId) {
		this.commandeId = commandeId;
	}

	public Double getPrixTotalCommande() {
		return PrixTotalCommande;
	}

	public void setPrixTotalCommande(Double prixTotalCommande) {
		PrixTotalCommande = prixTotalCommande;
	}

	public String getAddresseCommande() {
		return addresseCommande;
	}

	public void setAddresseCommande(String addresseCommande) {
		this.addresseCommande = addresseCommande;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDescriptionCommande() {
		return descriptionCommande;
	}

	public void setDescriptionCommande(String descriptionCommande) {
		this.descriptionCommande = descriptionCommande;
	}

	

	
	
}
