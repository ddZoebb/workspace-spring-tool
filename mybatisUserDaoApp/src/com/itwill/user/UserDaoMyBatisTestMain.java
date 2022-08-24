package com.itwill.user;

public class UserDaoMyBatisTestMain {

	public static void main(String[] args) throws Exception {
		UserDaoMyBatis userDaoMyBatis = new UserDaoMyBatis();
		System.out.println("------findUserList-----------");
		// System.out.println(userDaoMyBatis.findUserList());
		System.out.println("--findUser");
		System.out.println(userDaoMyBatis.findUser("guard1"));
		System.out.println("--findUserList");
		System.out.println(userDaoMyBatis.findUserList());
		System.out.println("--------insert");
		//System.out.println(userDaoMyBatis.create(new User("lotte", "1212", "롯데리아", "lotte")));
		System.out.println("---update");
		System.out.println(userDaoMyBatis.update(new User("lotte", "2345", "김변경", "update#naver.com")));
		System.out.println("--delete");
		System.out.println(userDaoMyBatis.remove("lotte"));
		System.out.println("--existedUser");
		System.out.println(userDaoMyBatis.existedUser("guard1"));
	}

}
