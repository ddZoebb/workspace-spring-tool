package com.itwill;

import com.itwill.repository.Chat_contentsDao;
import com.itwill.repository.Chat_contentsDaoImpl;

public class chatContentsDaoTest {
	public static void main(String[] args) {
		Chat_contentsDao chat_contentsDao=new Chat_contentsDaoImpl();
		
		System.out.println(chat_contentsDao);
		
		chat_contentsDao.chatSellectByRoom(1);
		
	}
	
	

}
