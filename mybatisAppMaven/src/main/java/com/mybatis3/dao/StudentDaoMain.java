package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		/**************************************************
	 	 SELECT 
		 **************************************************/
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultType :  DTO
		 */
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(studentDao.findStudentById(7));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(studentDao.findAllStudents());
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultMap :  DTO
		 */
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println(studentDao.findStudentByIdResultMap(5));
		System.out.println("---------findAllStudentsResultMap--------------------");
		System.out.println(studentDao.findAllStudentsResultMap());
		/**************************************************
	 	 SELECT[student + address JOIN]( 1 : 1 )
		 **************************************************/
		/*
		 * select sql의결과타입이 DTO,VO,Domain객체인경우
		 * resultMap : studentWithAddressResultMap
		 */
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println(studentDao.findStudentByIdWithAddress(1));
		System.out.println(studentDao.findStudentByIdWithAddress(2));
		/*********************************************************
		 * SELECT[students + courses[course_enrollment] JOIN( 1 : N )
		 ********************************************************/
		/*
		 * select sql의결과타입이 DTO,VO,Domain객체인경우
		 * resultMap : studentWithCoursesResultMap
		 */
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println(studentDao.findStudentByIdWithCourses(1));
		System.out.println(studentDao.findStudentByIdWithCourses(2));
		
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudent(Dto)--------------------------");
		System.out.println(studentDao.insertStudent(new Student(null, "김가네", "kim@naver.com",new Date(), null)));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student insertStudent=
			new Student(null, "시퀀스","sequence@naver.com" , new Date(), null);
		System.out.println("insert row count:"+studentDao.insertStudentBySequence1(insertStudent));
		System.out.println("insert sequence:"+insertStudent.getStudId());
		System.out.println("---------insertStudentBySequence2--------------------");
		System.out.println("insert sequence:"+studentDao.insertStudentBySequence2(insertStudent));
		
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		Student student=studentDao.findStudentById(1);
		student.setDob(new Date());
		student.setEmail("change222@gmail.com");
		student.setName("김윤수");
		System.out.println("update row count:"+studentDao.updateStudentById(student));
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("delete row count:"+
		studentDao.deleteStudentById(25));
		
		
	}
}
