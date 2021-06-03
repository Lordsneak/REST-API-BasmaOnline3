package org.basma.store.repositories;

import org.basma.store.entities.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long> {

	CategorieEntity findByTitreCategorie(String titreCategorie);

	CategorieEntity findByCategorieId(String categorieId);

	CategorieEntity findByIdCategorie(int idCategorie);
}