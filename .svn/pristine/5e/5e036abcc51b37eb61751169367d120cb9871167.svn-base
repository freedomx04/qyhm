package com.hm.qyhm.entity.authority;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hm.qyhm.entity.BaseEntity;

@Entity
@Table(name = "authority_user")
public class UserEntity extends BaseEntity {
	
	/**
	 *  用户名，唯一
	 */
	@Column(unique = true)
	private String username;	
	
	/**
	 * MD5加密后的密码
	 */
	private String password;	
	
	/**
	 * 联系电话
	 */
	private String telephone;	 
	
	/**
	 * 上次登录时间
	 */
	private Date lastLoginTime;
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String username, String password, String telephone, Date createTime, Date updateTime) {
		super();
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}