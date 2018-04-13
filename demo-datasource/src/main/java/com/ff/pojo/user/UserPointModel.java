package com.ff.pojo.user;

import java.util.Date;

/**
 * @author lg
 *
 */
public class UserPointModel {
    private Integer id;
	private String uid;
	private int point;
	private Date modifyTime;
	private int type;
	private String typeName;
	private Date addTime;
	private String dateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "UserPointModel [id=" + id + ", uid=" + uid + ", point=" + point + ", modifyTime=" + modifyTime
				+ ", type=" + type + ", typeName=" + typeName + ", addTime=" + addTime + ", dateTime=" + dateTime + "]";
	}

}
