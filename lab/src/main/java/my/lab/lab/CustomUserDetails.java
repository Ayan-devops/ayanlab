package my.lab.lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import antlr.collections.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetails implements UserDetails{

	@Autowired
	private Role role;
	
	private static final long serialVersionUID = 1L;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;
	
	private Collection<? extends GrantedAuthority> authorities;

	private Long id;

	private String email;

	private String password;

	public CustomUserDetails(Long id, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
       this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}

	public static CustomUserDetails build(User user) {
		java.util.List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new CustomUserDetails(
				user.getId(), 
				user.getEmail(),
				user.getPassword(), 
				authorities);
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return authorities;
    }

	@Override
	public String getPassword() {
		return user.getPassword();
		
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
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
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
