package org.basma.store.repositories;

import org.basma.store.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	ProductEntity findByProductId(String titleProduct);
	
	ProductEntity findByTitleProduct(String titleProduct);
	
}