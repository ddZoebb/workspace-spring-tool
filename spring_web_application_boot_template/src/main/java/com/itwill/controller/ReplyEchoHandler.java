package com.itwill.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@ServerEndpoint("/replyEcho")
public class ReplyEchoHandler extends TextWebSocketHandler {
Map<String, WebSocketSession> userSessions=new HashMap<>();

@OnOpen
public void afterConnectionEstablished(WebSocketSession session) throws Exception{
	System.out.println("연결 세션:"+session);
	String mId=(String)session.getAttributes().get("user_id"); //session에 저장된 id 찾기
	userSessions.put(mId, session);
}

@OnMessage
public void handleMessage(WebSocketSession session,TextMessage message) throws Exception{
	System.out.println(message.getPayload());
	String msg=message.getPayload(); // json형태의 문자열 
	if(!msg.isEmpty()) {
		String[] strs=msg.split(",");
		if(strs!=null&&strs.length==6) {
			String mId=strs[0];
			String yourId=strs[1];
			String contents=strs[2];
			String sendtime=strs[3];
			String c_room_no=strs[4];
			String chat_read=strs[5];
			
			WebSocketSession yourSession=userSessions.get(yourId); //상대방 세션 찾기
			if(yourSession!=null) {
				TextMessage tmpMsg=new TextMessage(mId+","+yourId+","+contents+","
						+sendtime+","+c_room_no+","+chat_read);
				yourSession.sendMessage(tmpMsg);
			}
		}
	}
}

@OnClose
@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		String mId=(String)session.getAttributes().get("user_id");
		System.out.println("커넥션 끝:"+mId);
	}


}
