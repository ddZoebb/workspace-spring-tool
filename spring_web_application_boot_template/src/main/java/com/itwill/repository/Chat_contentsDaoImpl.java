package com.itwill.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.domain.Chat_contents;
import com.itwill.mapper.Chat_contentsMapper;

@Repository
public class Chat_contentsDaoImpl implements Chat_contentsDao {
	@Autowired
	private Chat_contentsMapper chatContentsMapper;
	
	public Chat_contentsDaoImpl() {
		System.out.println(">>>>>>>>채팅 mapper:"+chatContentsMapper);
	}
	@Override
	public List<Chat_contents> chatSellectByRoom(int c_room_no) {
		// TODO Auto-generated method stub
		return chatContentsMapper.chatSellectByRoom(c_room_no);
	}

	@Override
	public Chat_contents chatSellectOne(int c_content_no) {
		// TODO Auto-generated method stub
		return chatContentsMapper.chatSellectOne(c_content_no);
	}

	@Override
	public int chatReadUpdate(int c_room_no) {
		// TODO Auto-generated method stub
		return chatContentsMapper.chatReadUpdate(c_room_no);
	}

	@Override
	public int chatDelete(int c_content_no) {
		// TODO Auto-generated method stub
		return chatContentsMapper.chatDelete(c_content_no);
	}

	@Override
	public int deleteChatUpdate(int c_content_no) {
		// TODO Auto-generated method stub
		return chatContentsMapper.deleteChatUpdate(c_content_no);
	}

	@Override
	public int insertChat(Chat_contents chat_contents) {
		// TODO Auto-generated method stub
		return chatContentsMapper.insertChat(chat_contents);
	}

}
