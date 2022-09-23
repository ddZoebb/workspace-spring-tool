package com.itwill;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	private List<WebSocketSession> sessionList=new ArrayList<WebSocketSession>();
	
	public void afterConnectionExtablished(WebSocketSession session) throws Exception{
		sessionList.add(session);
		
		//logger.info("{} 연결됨",session.getId());
	}
}
