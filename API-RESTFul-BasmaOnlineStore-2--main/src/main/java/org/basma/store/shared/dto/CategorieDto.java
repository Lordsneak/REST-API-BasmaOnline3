package org.basma.store.shared.dto;

import java.io.Serializable;

public class CategorieDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7624704134195738202L;

	private int idCategorie;
	private String categorieId;
	private String titreCategorie;

	
	
	
	public CategorieDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieDto(String titreCategorie) {
		super();
		this.titreCategorie = titreCategorie;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getCategorieId() {
		return categorieId;
	}
	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}
	public String getTitreCategorie() {
		return titreCategorie;
	}
	public void setTitreCategorie(String titreCategorie) {
		this.titreCategorie = titreCategorie;
	}



}
