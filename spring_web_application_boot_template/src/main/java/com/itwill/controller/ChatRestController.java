package com.itwill.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.domain.Chat_contents;
import com.itwill.service.ChatService;

//@RestController
public class ChatRestController {
	@Autowired
	private ChatService chatService;


	//채팅방의 저장되어있던 데이터  
	
	
	//@GetMapping(value="/chat_detail_rest", produces = "application/json;charset=UTF-8")
	public Map chatDetail_rest() {
		Map resultMap=new HashMap();
		int code=1;
		String url="";
		String msg="";
		String yourId="";
		List<Chat_contents> resultList=new ArrayList<Chat_contents>();
		try {
			List<Chat_contents> chatDetailList=chatService.chatSellectByRoom(3);
			code=1;
			msg="성공";
			resultList=chatDetailList;
		}catch (Exception e) {
			code=2;
			msg="성공";
			e.printStackTrace();
			
		}
		
		resultMap.put("code", code);
		resultMap.put("msg",msg);
		resultMap.put("data", resultList);
		
		return resultMap;
	}
	
	
	//메세지 전송 
		@PostMapping(value="/chat_message_rest")
		public String insertChat(@RequestBody Map<String,String> messages) {
			int rowCount=0;
			Chat_contents newChat=new Chat_contents(0, String.valueOf(messages.get("contents")),
					null, null, String.valueOf(messages.get("mId")), 
					Integer.valueOf(messages.get("c_room_no")));
			rowCount=chatService.insertChat(
						newChat
					);
			
			//insert 후  클라이언트에게 jsonObject  만들어서 보내기 
			
			JSONObject jsonObject=null;
			try {
				jsonObject=new JSONObject();
				jsonObject.put("mId", String.valueOf(messages.get("mId")));
				jsonObject.put("yourId", String.valueOf(messages.get("yourId")));
				jsonObject.put("contents", String.valueOf(messages.get("contents")));
				jsonObject.put("sendtime",chatService.chatSellectOne(newChat.getC_content_no()).getSend_time() );
				jsonObject.put("c_room_no", String.valueOf(messages.get("c_room_no")));
				jsonObject.put("chat_read", String.valueOf(messages.get("chat_read")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jsonObject.toString();
					
			
		}
	
	
/*
	
	
	//읽음(1)으로 변경
	@ResponseBody
	@GetMapping(value="/chat_readUpdate")
	public int chatReadUpdate(@RequestParam("c_room_no") int c_room_no) {
		return chatService.chatReadUpdate(c_room_no);
	}
	
	//메세지 삭제
	@ResponseBody
	@PostMapping(value="/chat_delete")
	public int chatDelete(@RequestParam("c_content_no") int c_content_no) {
		return chatService.chatDelete(c_content_no);
	}
	
	
	//메세지 전송 
	@ResponseBody
	@PostMapping(value="/chat_message")
	public String insertChat(@RequestBody Map<String,String> messages) {
		int rowCount=0;
		Chat_contents newChat=new Chat_contents(0, String.valueOf(messages.get("contents")),
				null, null, String.valueOf(messages.get("mId")), 
				Integer.valueOf(messages.get("c_room_no")));
		rowCount=chatService.insertChat(
					newChat
				);
		
		//insert 후  클라이언트에게 jsonObject  만들어서 보내기 
		
		JSONObject jsonObject=null;
		try {
			jsonObject=new JSONObject();
			jsonObject.put("mId", String.valueOf(messages.get("mId")));
			jsonObject.put("yourId", String.valueOf(messages.get("yourId")));
			jsonObject.put("contents", String.valueOf(messages.get("contents")));
			jsonObject.put("sendtime",chatService.chatSellectOne(newChat.getC_content_no()).getSend_time() );
			jsonObject.put("c_room_no", String.valueOf(messages.get("c_room_no")));
			jsonObject.put("chat_read", String.valueOf(messages.get("chat_read")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
				
		
	}
	*/
	
	

}
