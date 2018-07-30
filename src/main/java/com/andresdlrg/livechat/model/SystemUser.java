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
    @Index(value = "joinDate", type = IndexType.NonUnique),
    @Index(value = "username", type = IndexType.Unique)
})
public class SystemUser implements Serializable {
	
	private static final long serialVersionUID = 2758067479403278813L;
	
	private String username;
	private String password;
	private Date joinDate;
}
