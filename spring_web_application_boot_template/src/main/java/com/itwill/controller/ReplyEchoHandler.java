package com.itwill.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import org.springframework.web.socket.TextMessage;




@Component
@ServerEndpoint("/replyEcho")
public class ReplyEchoHandler {
//private Map<String, WebSocketSession> userSessions=new HashMap<>();

private static Map<String, Session> userSessions=new HashMap();
//private static List<Session> list=new ArrayList<Session>();





 
//@PathParam("mId") String mId
@OnOpen
public void handleOpen(Session session) {
	String mId=session.getQueryString();
	System.out.println("연결 세션:"+session);
	System.out.println("아이디:"+mId);
	
	userSessions.put(mId, session);
}

/*
public void afterConnectionEstablished(WebSocketSession session) throws Exception{
	System.out.println("연결 세션:"+session);
	String mId=(String)session.getAttributes().get("user_id"); //session에 저장된 id 찾기
	userSessions.put(mId, session);
}
*/

@OnMessage
public void handleMessage(String message,Session session) {
	System.out.println("메세지 전송:"+session);
}

/*
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
*/

@OnClose
public void handleClose(Session session) {
	System.out.println("socket 닫기:"+session);
}

/*
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		String mId=(String)session.getAttributes().get("user_id");
		System.out.println("커넥션 끝:"+mId);
	}
	*/


}
