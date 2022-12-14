package com.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.domain.Chat_contents;

@Mapper
public interface Chat_contentsMapper {
	//채팅방 1개의 전체 채팅 내용 불러오기 
	@Select("select * from chat_contents where c_room_no=#{c_room_no} order by c_content_no")
	public List<Chat_contents> chatSellectByRoom(@Param("c_room_no") int c_room_no);
	
	//채팅 1개 select
	@Select("select * from chat_contents where c_content_no=#{c_content_no}")
	public Chat_contents chatSellectOne(@Param("c_content_no") int c_content_no);
	
	/*
	 * //안읽은 메세지 몇 개인지 체크
	 * 
	 * @Select("select count(*) from chat_contents where c_room_no=1 and c_read=0 and user_id!='carrot1'"
	 * ) public int chatReadCheck();
	 */
	
	//읽음 확인 변경 
	@Update("update chat_contents set c_read=1 where c_room_no=#{c_room_no} and send_time<sysdate")
	public int chatReadUpdate(@Param("c_room_no") int c_room_no);
	
	//채팅 한 개 삭제
	@Delete("delete chat_contents where c_content_no=#{c_content_no}")
	public int chatDelete(@Param("c_content_no") int c_content_no);
	
	//채팅 삭제(사용자)시 메세지 대체 (db)
	@Update("update chat_contents set c_content='삭제된 메세지입니다.' where c_content_no=#{c_content_no}")
	public int deleteChatUpdate(@Param("c_content_no") int c_content_no);
	
	//채팅 insert
	@Insert("insert into chat_contents (c_content_no,c_content,send_time,c_read,user_id,c_room_no)"
			+ "values (#{c_content_no},#{c_content},sysdate,0,#{user_id},#{c_room_no})")
	@SelectKey(statement = "select chat_contents_c_content_no_SEQ.nextval from dual",
	keyProperty = "c_content_no",
	before = true,
	resultType = Integer.class
	)
	public int insertChat(Chat_contents chat_contents);

}
