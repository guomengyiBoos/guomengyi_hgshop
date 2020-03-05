package com.mengyi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 閰嶇疆绫� 璇诲彇灞炴�ф枃浠�
 * @author zhuzg
 *
 */
@Configuration
@PropertySource("classpath:hdshop-admin.properties")
public class AdminProperties {
	
	@Value("${amdin.name}")
	String adminName;
	
	@Value("${admin.pwd}")
	String password;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
