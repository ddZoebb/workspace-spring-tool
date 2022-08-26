package com.mybatis3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.dao.mapper.StudentMapper.";
	public StudentDao() {
		try {
			sqlSessionFactory=
					new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis-config.xml")); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**************************************************
	 * SELECT [student]
	 **************************************************/
	/*
	 select sql의결과타입이 DTO[DTO List] 객체인경우
	 resultType :  DTO
	*/
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=sqlSession.selectOne(NAMESPACE+"findStudentById",studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Student> studentList=sqlSession.selectList("com.mybatis3.dao.mapper.StudentMapper.findAllStudents");
		sqlSession.close();
		return studentList;
	}

	/*
	 * select sql의결과타입이 DTO[DTO List] 객체인경우
	 * resultMap :  DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=
				sqlSession.selectOne(NAMESPACE+"findStudentByIdResultMap",studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		sqlSession.close();
		return studentList;
	}

	/**************************************************
	 * SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우
	 * resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=
				sqlSession.selectOne(NAMESPACE+"findStudentByIdWithAddress",studId);
		sqlSession.close();
		return student;
	}

	/*********************************************************
	 * SELECT[students + courses[course_enrollment]+course] JOIN( 1 : N )
	 ********************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우
	 * resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student =
				sqlSession.selectOne(NAMESPACE+"findStudentByIdWithCourses",studId);
		sqlSession.close();
		return student;
	}

	/**************************************************
	 * INSERT
	 ***************************************************/
	/*
	parameterType: DTO,VO,Domain
	*/
	public int insertStudent(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.insert(NAMESPACE+"insertStudent",student);
		sqlSession.close();
		return rowCount;
	}

	public int insertStudentBySequence1(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequence1",student);
		sqlSession.close();
		return rowCount;
	}
	public int insertStudentBySequence2(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequence1",student);
		sqlSession.close();
		return student.getStudId();
	}



	/**************************************************
	 * UPDATE
	 ***************************************************/
	/*
	  parameterType: DTO,VO,Domain
	 */
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int rowCount=sqlSession.update(NAMESPACE+"updateStudentById",updateStudent);
		sqlSession.commit();
		sqlSession.close();
		return rowCount;
	}

	/**************************************************
	 * DELETE
	 ***************************************************/
	/*
	 parameterType: java.lang.Integer,java.lang.String
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.delete(NAMESPACE+"deleteStudentById",studId);
		sqlSession.close();
		return rowCount;
	}

}












