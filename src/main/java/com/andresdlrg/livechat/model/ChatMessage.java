package com.andresdlrg.livechat.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ChatMessage implements Serializable{

	private static final long serialVersionUID = 3051617307402320295L;

	private String chatId;
	private int messageType;
	private String message;
	private Date timestamp;
	private String originator;
	private String destination;
	
}
