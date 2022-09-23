package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;


@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	@GetMapping(value = {
						"/guest_write_action_json",
						"/guest_remove_action_json",
						"/guest_modify_form_json",
						"/guest_modify_action_json"
						},
			produces = "application/json;charset=UTF-8")
	public Map guest_json_get() {
		Map resultMap=new HashMap();
		int code=2;
		String url="guest_main";
		String msg="잘못된 요청방식입니다.";
		List<Guest> resultList=new ArrayList<Guest>();
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		return resultMap;
	}
	@PostMapping(value = "/guest_modify_action_json",
			produces = "application/json;charset=UTF-8")
	public Map guest_modify_action_json(@ModelAttribute Guest guest) {
		Map resultMap=new HashMap();
		int code=2;
		String url="";
		String msg="";
		List<Guest> resultList=new ArrayList<Guest>();
		try {
			code=1;
			url="";
			msg="";
			int row_count=guestService.updateGuest(guest);
		} catch (Exception e) {
			code=2;
			url="";
			msg="방명록수정실패";
			e.printStackTrace();
		}
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		
		return resultMap;
	}
	@PostMapping(value = "/guest_modify_form_json",
			produces = "application/json;charset=UTF-8")
	public Map guest_modify_form_json(@RequestParam int guest_no) {
		Map resultMap=new HashMap();
		int code=2;
		String url="";
		String msg="";
		List<Guest> resultList=new ArrayList<Guest>();
		try {
			code=1;
			url="";
			msg="";
			Guest guest=guestService.selectByNo(guest_no);
			resultList.add(guest);
		} catch (Exception e) {
			code=2;
			url="";
			msg="방명록수정폼실패";
			e.printStackTrace();
		}
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		
		return resultMap;
	}
	@PostMapping(value = "/guest_remove_action_json",
			produces = "application/json;charset=UTF-8")
	public Map guest_remove_action_json(@RequestParam int guest_no) {
		Map resultMap=new HashMap();
		int code=2;
		String url="";
		String msg="";
		List<Guest> resultList=new ArrayList<Guest>();
		try {
			code=1;
			url="";
			msg="";
			int row_count=guestService.deleteGuest(guest_no);
			
		} catch (Exception e) {
			code=2;
			url="";
			msg="방명록삭제실패";
			e.printStackTrace();
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		
		return resultMap;
	}
	
	
	@PostMapping(value = "/guest_write_action_json",
			produces = "application/json;charset=UTF-8")
	public Map guest_write_action_json(@ModelAttribute Guest guest) {
		Map resultMap=new HashMap();
		int code=2;
		String url="";
		String msg="";
		List<Guest> resultList=new ArrayList<Guest>();
		try {
			code=1;
			url="";
			msg="";
			int insert_guest_no=guestService.insertGuest(guest);
			resultList.add(
					new Guest(insert_guest_no, "", "", "","", "",""));
			
		} catch (Exception e) {
			code=2;
			url="";
			msg="방명록쓰기실패";
			e.printStackTrace();
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		
		return resultMap;
	}
	
	
	@RequestMapping(value = "/guest_detail_json",
			produces = "application/json;charset=UTF-8")
	public Map guest_detail_json(@RequestParam int guest_no) {
		Map resultMap=new HashMap();
		int code=1;
		String url="";
		String msg="";
		List<Guest> resultList=new ArrayList<Guest>();
		
		try {
			Guest guest =guestService.selectByNo(guest_no);
			code=1;
			url="guest_detail";
			msg="";
			resultList.add(guest);
		} catch (Exception e) {
			code=2;
			url="guest_error";
			msg="방명록상세보기실패";
			e.printStackTrace();
		}
		
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		
		return resultMap;
	}
	
	
	@RequestMapping(value = "/guest_list_json",
					produces = "application/json;charset=UTF-8")
	public Map guest_list_json() {
		Map resultMap=new HashMap();
		int code=1;
		String url="";
		String msg="";
		List<Guest> resultList=new ArrayList<Guest>();
		try {
			List<Guest> guestList = guestService.selectAll();
			code=1;
			url="guest_list";
			msg="성공";
			resultList=guestList;
		} catch (Exception e) {
			code=2;
			url="guest_main";
			msg="실패";
			e.printStackTrace();
		}
		
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",resultList);
		
		return resultMap;
	}

}