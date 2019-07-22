package ca.kuroshfarsimadan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.kuroshfarsimadan.dao.ProductDao;
import ca.kuroshfarsimadan.exception.ResourceNotFoundException;
import ca.kuroshfarsimadan.model.Product;

@RestController
@RequestMapping("/api/v2")
public class ProductController {
	@Autowired
	private ProductDao productRepository;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productID)
			throws ResourceNotFoundException {
		Product product = productRepository.findOne(productID);

		return ResponseEntity.ok().body(product);
	}

	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productID,
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = productRepository.findOne(productID);
		product.setProductName(productDetails.getProductName());
		final Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findOne(productId);
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
