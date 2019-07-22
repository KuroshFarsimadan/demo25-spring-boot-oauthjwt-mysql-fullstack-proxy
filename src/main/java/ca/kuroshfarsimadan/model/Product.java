package ca.kuroshfarsimadan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	private long productID;
	private String productName;

	public Product() {

	}

	/**
	 * @param productID
	 * @param productName
	 */
	public Product(long productID, String productName) {
		// super();
		this.productID = productID;
		this.productName = productName;
	}

	/**
	 * @return the productID
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(long productID) {
		this.productID = productID;
	}

	/**
	 * @return the productName
	 */
	@Column(name = "product_name", nullable = false)
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
