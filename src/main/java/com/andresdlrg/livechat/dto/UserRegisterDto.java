package com.andresdlrg.livechat.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserRegisterDto {
	
	@NotNull
	@Length(min=5, max=20)
	private String username;
	
	@NotNull
	@Length(min=5, max=20)
	private String password;
	
	private String confirmPassword;
}
