package com.andresdlrg.livechat.model;

import java.io.Serializable;
import java.util.Date;

import org.dizitart.no2.IndexType;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Indices({
    @Index(value = "timestamp", type = IndexType.NonUnique),
})
public class ChatMessage implements Serializable{

	private static final long serialVersionUID = 3051617307402320295L;

	private String chatId;
	private int messageType;
	private String message;
	private Date timestamp;
	private String originator;
	private String destination;
	
}
