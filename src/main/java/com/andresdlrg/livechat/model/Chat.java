package com.andresdlrg.livechat.model;

import java.io.Serializable;
import java.util.List;

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
    @Index(value = "members", type = IndexType.NonUnique),
    @Index(value = "chatId", type = IndexType.Unique)
})
public class Chat implements Serializable {

	private static final long serialVersionUID = 1L;

	private String chatId;
	// usernames of participants
	private List<String> members;
	private String creatorUsername;
	private String name;
}
