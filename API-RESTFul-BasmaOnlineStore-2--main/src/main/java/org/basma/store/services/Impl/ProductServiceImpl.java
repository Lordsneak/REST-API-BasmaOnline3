package org.basma.store.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.basma.store.entities.ProductEntity;
import org.basma.store.repositories.CategorieRepository;
import org.basma.store.repositories.ProductRepository;
import org.basma.store.services.ProductService;
import org.basma.store.shared.Utils;
import org.basma.store.shared.dto.CategorieDto;
import org.basma.store.shared.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	Utils util;

	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public ProductDto createProduct(int categorie, ProductDto product) {

		ProductEntity productEntity = new ProductEntity();

		ProductEntity checkProduct = productRepository.findByTitleProduct(product.getTitleProduct());

		if (checkProduct != null)
			throw new RuntimeException("Product Alrady Exists !");

		BeanUtils.copyProperties(product, productEntity);

		productEntity.setCategorie(categorieRepository.findByIdCategorie(categorie));

		productEntity.setProductId(util.generateStringId(32));

		ProductEntity newProduct = productRepository.save(productEntity);

		ProductDto prodyctDto = new ProductDto();

		BeanUtils.copyProperties(newProduct, prodyctDto);

		return prodyctDto;
	}

	@Override
	public ProductDto getProduct(String titleProduct) {

		ProductEntity productEntity = productRepository.findByTitleProduct(titleProduct);

		if (productEntity == null)
			throw new UsernameNotFoundException(titleProduct);

		ProductDto prodyctDto = new ProductDto();

		BeanUtils.copyProperties(productEntity, prodyctDto);

		return prodyctDto;
	}

	@Override
	public ProductDto getProductByProductId(String idProduct) {

		ProductEntity productEntity = productRepository.findByProductId(idProduct);

		if (productEntity == null)
			throw new UsernameNotFoundException(idProduct);

		ProductDto prodyctDto = new ProductDto();

		BeanUtils.copyProperties(productEntity, prodyctDto);

		return prodyctDto;
	}

	@Override
	public ProductDto updateProduct(String id, ProductDto productDto) {

		ProductEntity productEntity = productRepository.findByProductId(id);
				if (productEntity == null)
			throw new UsernameNotFoundException(id);

		productEntity.setTitleProduct(productDto.getTitleProduct());
		productEntity.setDescriptionProduct(productDto.getDescriptionProduct());
		productEntity.setQtStockProduct(productDto.getQtStockProduct());
		productEntity.setPrixProduct(productDto.getPrixProduct());
		

		ProductEntity productUpdate = productRepository.save(productEntity);

		ProductDto product = new ProductDto();

		BeanUtils.copyProperties(productUpdate, product);

		return product;
	}

	@Override
	public void deleteProduct(String idProduct) {

		ProductEntity productEntity = productRepository.findByProductId(idProduct);

		if (productEntity == null)
			throw new UsernameNotFoundException(idProduct);

		productRepository.delete(productEntity);

	}

	@Override
	public List<ProductDto> getProducts(int page, int limit) {
		if(page > 0) page = page -1;
		
		List<ProductDto> productsDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<ProductEntity> productPage =	productRepository.findAll(pageableRequest);
		
		List<ProductEntity> products = productPage.getContent();
		
		for(ProductEntity productEntity: products) {
			ProductDto produit = new ProductDto();
			
			BeanUtils.copyProperties(productEntity, produit);
			
			productsDto.add(produit);
		}
		return productsDto;
	}

}
