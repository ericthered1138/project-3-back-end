package com.project3.revtech.controller.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "discount_details")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discount_id")
	private int discountId;

	@Column(name = "product_id")
	private int productId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private Product product;

	@Column(name = "discount_description")
	private String discountDescription;

	@Column(name = "discount_percentage")
	private BigDecimal discountPercentage;

	public Discount(int discountId, int productId, Product product, String discountDescription,
			BigDecimal discountPercentage) {
		super();
		this.discountId = discountId;
		this.productId = productId;
		this.product = product;
		this.discountDescription = discountDescription;
		this.discountPercentage = discountPercentage;
	}

	public Discount(int discountId, int productId, String discountDescription, BigDecimal discountPercentage) {
		this.discountId = discountId;
		this.productId = productId;
		this.discountDescription = discountDescription;
		this.discountPercentage = discountPercentage;
	}

	public Discount(boolean isNull) {
		if(isNull) {
			this.discountId = -1;
			this.productId = -1;
			this.discountDescription = "N/A";
			this.discountPercentage = new BigDecimal("0.0123");
		}
	}
}