package org.basma.store.responses;

public class CommandeResponse {
	
	private String commandeId;
	private Double PrixTotalCommande;
	private String addresseCommande;
	private String ville;
	private String descriptionCommande;
	

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
