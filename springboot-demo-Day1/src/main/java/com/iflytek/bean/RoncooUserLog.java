/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.iflytek.bean;

import java.util.Date;

/**
 * 用户日志记录
 * 
 * @author wujing
 */
public class RoncooUserLog {

	private Integer id;

	private Date createTime;

	private String userName;

	private String userIp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	@Override
	public String toString() {
		return "RoncooUserLog [id=" + id + ", createTime=" + createTime + ", userName=" + userName + ", userIp=" + userIp + "]";
	}

}
