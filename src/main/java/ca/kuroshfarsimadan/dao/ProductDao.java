package ca.kuroshfarsimadan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.kuroshfarsimadan.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

}
