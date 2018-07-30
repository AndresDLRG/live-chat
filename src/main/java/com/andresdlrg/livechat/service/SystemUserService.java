package com.andresdlrg.livechat.service;

import com.andresdlrg.livechat.model.SystemUser;

public interface SystemUserService {

	SystemUser getSystemUserByUsername(String username);
	
	boolean createSystemUser(SystemUser user);
}
