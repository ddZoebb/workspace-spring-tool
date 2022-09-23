package com.itwill;

import java.sql.Timestamp;

//import lombok.Data;
 
 
public class ChatRoom {
 
	private int c_no;
	private int p_no;
	private String u_id;
	private String u2_id;
	private String content;
	private String senddate;
	
	public ChatRoom() {
		// TODO Auto-generated constructor stub
	}
	
	public ChatRoom(int c_no, int p_no, String u_id, String u2_id, String content, String senddate) {
		super();
		this.c_no = c_no;
		this.p_no = p_no;
		this.u_id = u_id;
		this.u2_id = u2_id;
		this.content = content;
		this.senddate = senddate;
	}
	
	
	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU2_id() {
		return u2_id;
	}

	public void setU2_id(String u2_id) {
		this.u2_id = u2_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSenddate() {
		return senddate;
	}

	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}

	@Override
	public String toString() {
		return "ChatRoom [c_no=" + c_no + ", p_no=" + p_no + ", u_id=" + u_id + ", u2_id=" + u2_id + ", content="
				+ content + ", senddate=" + senddate + "]";
	}
	
	
	
	
}