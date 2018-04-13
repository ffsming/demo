package com.ff.pojo.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserModel 
 * @Description: TODO(用户表实体类) 
 * @author CongZN
 * @date 2017年10月12日 下午4:59:50 
 * @version V1.0 
 *
 * <p> 修改历史</p>
 * <p> 序号 日期 修改人 修改原因</p>
 */
public class UserModel implements Serializable{
	
	private static final long serialVersionUID = -2946092088962799437L;
	
	private Integer id;
	private Long uid;
	private String uuid;
	private Date addTime;
	private Date modifyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "UserModel{" +
				"id=" + id +
				", uid=" + uid +
				", uuid='" + uuid + '\'' +
				", addTime=" + addTime +
				", modifyTime=" + modifyTime +
				'}';
	}
}
