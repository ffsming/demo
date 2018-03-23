package com.hxwy.pojo.message;

import java.io.Serializable;
import java.util.Date;

public class MessageDetailModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6132521703749630303L;
	private Integer id;
	private Integer type;
	private String uid;
	private String openid;
	private String message;
	private Date sendTime;
	private Integer status;
	private Date addTime;
	private Date actualSendTime;
	private Date updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getActualSendTime() {
		return actualSendTime;
	}
	public void setActualSendTime(Date actualSendTime) {
		this.actualSendTime = actualSendTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "MessageInfoModel [id=" + id + ", type=" + type + ", uid=" + uid + ", openid=" + openid + ", message="
				+ message + ", sendTime=" + sendTime + ", status=" + status + ", addTime=" + addTime
				+ ", actualSendTime=" + actualSendTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
