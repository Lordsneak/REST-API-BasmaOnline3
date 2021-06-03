package org.basma.store.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;

import org.basma.store.entities.CategorieEntity;

public class ProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7847950237834629532L;

	private long id;
	
	private String productId;
	
	private String titleProduct;
	
	private String descriptionProduct;
	
	private double prixProduct;
	
	private int qtStockProduct;
	
	ArrayList<String> listImages = new ArrayList<String>();
	
	private int idCategorie;
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}



	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitleProduct() {
		return titleProduct;
	}

	public void setTitleProduct(String titleProduct) {
		this.titleProduct = titleProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public double getPrixProduct() {
		return prixProduct;
	}

	public void setPrixProduct(double prixProduct) {
		this.prixProduct = prixProduct;
	}

	public int getQtStockProduct() {
		return qtStockProduct;
	}

	public void setQtStockProduct(int qtStockProduct) {
		this.qtStockProduct = qtStockProduct;
	}

	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getListImages() {
		return listImages;
	}

	public void setListImages(ArrayList<String> listImages) {
		this.listImages = listImages;
	}

	 
	

}
