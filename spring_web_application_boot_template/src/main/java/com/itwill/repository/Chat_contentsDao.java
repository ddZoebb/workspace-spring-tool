package com.itwill.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.domain.Chat_contents;

public interface Chat_contentsDao {
	public List<Chat_contents> chatSellectByRoom(int c_room_no);
	
	public Chat_contents chatSellectOne(int c_content_no);
	
	public int chatReadUpdate(int c_room_no);
	
	public int chatDelete(int c_content_no);
	
	public int deleteChatUpdate(int c_content_no);
	
	public int insertChat(Chat_contents chat_contents);




	
	


}
