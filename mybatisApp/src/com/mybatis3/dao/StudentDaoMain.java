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
		  resultType :  Dto
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
		System.out.println(studentDao.findStudentByIdWithAddress(7));
		System.out.println("---------findStudentByIdWithCourses------------------");
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudent(Dto)--------------------------");
		System.out.println(studentDao.insertStudent(new Student(null,"인서트","insert@naver.com",new Date(),null)));
		System.out.println("---------insertStudentBySequence1--------------------");
		System.out.println("---------insertStudentBySequence2--------------------");
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		System.out.println(studentDao.updateStudentById(new Student(11,"업데이트","update@daum.net",new Date(),null)));
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println(studentDao.deleteStudentById(12));
		
		
	}
}
