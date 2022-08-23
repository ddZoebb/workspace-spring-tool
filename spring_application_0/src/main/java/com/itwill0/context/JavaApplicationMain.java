package com.itwill0.context;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductDaoImpl;
import com.itwill.product.ProductService;
import com.itwill.product.ProductServiceImpl;

public class JavaApplicationMain {
	public static void main(String[] args) {
		/*case 1
		 * 
		 * ProductService productService=new ProductService();
		 * System.out.println(productService.productList());
		 * System.out.println(productService.productDetail(123));
		 */
		
		/*
		 * case 2 
		 */
		/*
		 * ProductDao productDaoImpl=new ProductDaoImpl(); ProductService
		 * productService=new ProductService(productDaoImpl);
		 * System.out.println(productService.productList());
		 * System.out.println(productService.productDetail(123));
		 */
		
		
		/*
		 * case3
		 */
		ProductDao productDao=new ProductDaoImpl();
		ProductService productService=new ProductServiceImpl();
		productService.setProductDao(productDao);
		
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(123));
	}
}
