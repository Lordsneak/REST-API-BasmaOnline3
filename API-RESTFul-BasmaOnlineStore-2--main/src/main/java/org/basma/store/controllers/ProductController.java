package org.basma.store.controllers;

import java.util.ArrayList;
import java.util.List;

import org.basma.store.repositories.CategorieRepository;
import org.basma.store.requests.ProductRequest;
import org.basma.store.responses.ProductResponse;
import org.basma.store.services.ProductService;
import org.basma.store.shared.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products") // localhost:8080/products
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategorieRepository categorieRepository;
	
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ProductResponse> getAllProduits(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {

		List<ProductResponse> produitReponse = new ArrayList<>();

		List<ProductDto> produits = productService.getProducts(page, limit);

		for (ProductDto produitDto : produits) {
			
			ProductResponse prod = new ProductResponse();

			BeanUtils.copyProperties(produitDto, prod);

			produitReponse.add(prod);
		}
		
		return produitReponse;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable String id) {

		ProductDto productDto = productService.getProductByProductId(id);

		ProductResponse productResponse = new ProductResponse();

		BeanUtils.copyProperties(productDto, productResponse);

		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) throws Exception {

		ProductDto productDto = new ProductDto();

		BeanUtils.copyProperties(productRequest, productDto);

		ProductDto createProduct = productService.createProduct(productRequest.getIdCategorie(), productDto);
		System.out.println(productRequest.getIdCategorie());
		ProductResponse productResponse = new ProductResponse();

		BeanUtils.copyProperties(createProduct, productResponse);

		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);

	}
	
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductResponse> updateproduit(@PathVariable String id,
			@RequestBody ProductRequest produitRequest) {

		ProductDto produitDto = new ProductDto();

		BeanUtils.copyProperties(produitRequest, produitDto);

		ProductDto updateProduit = productService.updateProduct(id, produitDto);

		ProductResponse produitReponse = new ProductResponse();

		BeanUtils.copyProperties(updateProduit, produitReponse);

		return new ResponseEntity<>(produitReponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path ="/{id}") // pour supprime produit
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		productService.deleteProduct(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
