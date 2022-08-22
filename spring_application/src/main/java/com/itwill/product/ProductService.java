package com.itwill.product;

import java.util.List;

public class ProductService {
	private ProductDao productDao;

	public ProductService() {
	}
	
	public ProductService(ProductDao productDao) {
		this.productDao=productDao;
	}
	
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	

	public List<Product> productList() {
		return productDao.productList();
	}
	
	public Product productDetail(int p_no) {
		return productDao.productDetail(p_no);	
		}

}
