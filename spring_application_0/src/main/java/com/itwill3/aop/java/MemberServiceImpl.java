package com.itwill3.aop.java;

public class MemberServiceImpl implements MemberService {
	//private LoggingBeforeAdvice loggingBeforeAdvice=new LoggingBeforeAdvice();
	@Override
	public void create() {
		//loggingBeforeAdvice.beforeLog();
		System.out.println("### MemberServiceImpl.create()");
	}

	@Override
	public void login() {
		//loggingBeforeAdvice.beforeLog();

		System.out.println("### MemberServiceImpl.login()");

	}

	@Override
	public void list() {
		//loggingBeforeAdvice.beforeLog();

		System.out.println("### MemberServiceImpl.list()");
	}

	@Override
	public void view() {
		//loggingBeforeAdvice.beforeLog();

		System.out.println("### MemberServiceImpl.view()");
	}

}
