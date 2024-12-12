package com.ashutosh.config;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ashutosh.binding.credentialBinding;


public class CustomUserDetails  implements UserDetails{
	
	private String username;
	private String password;
	private String activeSt;
	
	
	public CustomUserDetails(credentialBinding cred){
				 this.username = cred.getUserName();
		 this.password = cred.getPassword();
		 this.activeSt = cred.getActiveSt();
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
	         if(activeSt.equals("Y")) {
	        
	        	  return true;
	         }
	         else {
	        	  return false;
	         }
		
	}

}
