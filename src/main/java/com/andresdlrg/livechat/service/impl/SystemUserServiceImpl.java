package com.andresdlrg.livechat.service.impl;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andresdlrg.livechat.model.SystemUser;
import com.andresdlrg.livechat.service.SystemUserService;

@Service
public class SystemUserServiceImpl implements SystemUserService {

	private BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder(); 
	
	@Autowired
	private Nitrite nitriteDb;
	
	@Override
	public SystemUser getSystemUserByUsername(String username) {
		return nitriteDb.getRepository(SystemUser.class).find(eq("username", username)).firstOrDefault();
	}

	@Override
	public boolean createSystemUser(SystemUser user) {
		user.setPassword(passEncoder.encode(user.getPassword()));
		WriteResult result = nitriteDb.getRepository(SystemUser.class).insert(user);
		return result.getAffectedCount() > 0;
	}

}
