package org.basma.store.services;

import java.util.List;

import org.basma.store.shared.dto.CategorieDto; 

public interface CategorieService {

	CategorieDto createCategorie(CategorieDto categorie);

	CategorieDto getCategorie(String titreCategorie);

	CategorieDto getCategorieByCategorieId(String categorieId);

	CategorieDto updateCategorie(String id, CategorieDto categorieDto);

	void deleteCategorie(String categorieId);

	List<CategorieDto> getCategories(int page, int limit);
}