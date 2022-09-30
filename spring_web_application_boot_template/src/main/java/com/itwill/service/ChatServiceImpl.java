package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.domain.Chat_contents;
import com.itwill.repository.Chat_contentsDao;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired 
	Chat_contentsDao chat_contentsDao;
	
	public ChatServiceImpl() {
		System.out.println(">>>>> 채팅 service 생성");
	}

	@Override
	public List<Chat_contents> chatSellectByRoom(int c_room_no) {
		// TODO Auto-generated method stub
		return chat_contentsDao.chatSellectByRoom(c_room_no);
	}

	@Override
	public Chat_contents chatSellectOne(int c_content_no) {
		// TODO Auto-generated method stub
		return chat_contentsDao.chatSellectOne(c_content_no);
	}

	@Override
	public int chatReadUpdate(int c_room_no) {
		// TODO Auto-generated method stub
		return chat_contentsDao.chatReadUpdate(c_room_no);
	}

	@Override
	public int chatDelete(int c_content_no) {
		// TODO Auto-generated method stub
		return chat_contentsDao.chatDelete(c_content_no);
	}

	@Override
	public int deleteChatUpdate(int c_content_no) {
		// TODO Auto-generated method stub
		return chat_contentsDao.deleteChatUpdate(c_content_no);
	}

	@Override
	public int insertChat(Chat_contents chat_contents) {
		// TODO Auto-generated method stub
		return chat_contentsDao.insertChat(chat_contents);
	}

	@Override
	public String testService() {
		// TODO Auto-generated method stub
		String str= "ChatService 호출 테스트";
		return str;
	}

	
	

}
