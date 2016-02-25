package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
	private static final long serialVersionUID = 2487260827926619595L;
	
	private String id;
	private String re_content;  //留言回复内容
	private Date replyTime;	//回复时间
	private String topic;		//主题
	private Message message;	//所属留言
	private String reply_user_id;	//回复用户id
	
	public String getReply_user_id() {
		return reply_user_id;
	}
	public void setReply_user_id(String reply_user_id) {
		this.reply_user_id = reply_user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	
}
