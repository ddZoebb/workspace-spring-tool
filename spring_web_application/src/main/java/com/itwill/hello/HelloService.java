package com.itwill.hello;

import java.util.List;

public class HelloService {
	private HelloDao helloDao;
	
	public HelloService() {
		System.out.println("2.### helloService() 생성자 호출");
	}

	public void setHelloDao(HelloDao helloDao) {
		System.out.println("3.## setHelloDao 메소드 호출");
		this.helloDao = helloDao;
	}
	
	public List<Hello> helloList(){
		System.out.println("B.### helloList() 메소드");
		return helloDao.helloList();
	}
	
	
	

}
