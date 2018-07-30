package com.andresdlrg.livechat.service.impl;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

import java.util.ArrayList;

import org.dizitart.no2.Nitrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.andresdlrg.livechat.model.SystemUser;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private Nitrite nitriteDb;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SystemUser sysUser = nitriteDb.getRepository(SystemUser.class).find(eq("username", username)).firstOrDefault();
		return new User(sysUser.getUsername(), sysUser.getPassword(), new ArrayList<>());
	}

}
