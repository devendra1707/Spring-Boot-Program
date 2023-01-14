package com.springboot.customdbsecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails  extends Users implements UserDetails{


	//UserDetails - > Spring boot Framework predefined class -> Users, Roles and User To Roles

	//Users -> Its our database @Entity (users)



	/*
	 @Override
    public String getUsername() {
        return super.getName();
    }
	 */

	public CustomUserDetails(final Users users) {
        super(users);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


    	/* Get Roles -> ADMIN,GUEST,SECURITY,SUPERADMIN -> RAMU
    	 *
    	 * user_role -> ramu-> ADMIN,ramu->SECURITY,ramu->GUEST, ramu-> SUPERADMIN
    	 *
    	 * ROLE_ADMIN,ROLE_SECURITY,ROLE_GUEST,ROLE_SUPERADMIN
    	 *
    	 * List<SimpleGrantedAuthority> authorityList=new ArrayList<SimpleGrantedAuthority>();
    	 *  Iterate for each (role:Role)
    	 *  {
    	 *  SimpleGrantedAuthority obj=new SimpleGrantedAuthority("ROLE_"+role);
    	 *  authorityList.add(obj);
    	 *
    	 *  }
    	 * return authorityList;
    	 */
    	//RAMU -> ADMIN,GUEST,MANAGER,SECURITY -> ROLE_ADMIN,ROLE_GUEST,ROLE_MANAGER,ROLE_SECURITY


        return getRoles() //This object goes to database and gets the roles using select * from user_roles
                .stream() //This stream API which will internally iterate and call map method
                .map(role -> new
                		SimpleGrantedAuthority("ROLE_" + role.getRole())
                	) //Our business Logic to update the our main object
                .collect(Collectors.toList());  // This will convert teh entire result to List Object or Collection Object



    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
    	//
    	//if super.lastlogintime >== java.util.date() -> false elese true
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
