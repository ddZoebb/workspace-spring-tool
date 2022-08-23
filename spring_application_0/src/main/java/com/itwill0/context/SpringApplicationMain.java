package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.product.ProductService;

public class SpringApplicationMain {

	public static void main(String[] args) {
		/*
		 * Spring container 객체생성
		 * -ApplicationContext[BeanFactory] 객체생성 
		 */
		/*
		 * 1.Spring Bean 설정파일 읽어 SpringContainer객체생성
		 */
		System.out.println("-----ApplicationContext 생성시작--------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("0.applicationContext.xml");
		System.out.println("-----ApplicationContext 생성끝--------");
		
		/*
		 * 2.Spring Container 객체 [applicationContext 객체]로부터 productService 아이디 객체 참조얻기
		 */
		ProductService productService=(ProductService)applicationContext.getBean("productService");
		System.out.println(productService);
		
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(123));
		
	}

}
