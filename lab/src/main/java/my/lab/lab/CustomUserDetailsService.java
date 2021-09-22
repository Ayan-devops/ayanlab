package my.lab.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user= repo.findByemail(email);
		
		CustomUserDetails userDetails =null;
		if (user!= null)
			
		{
			userDetails= new CustomUserDetails();
			userDetails.setUser(user);;
			
		}
		
		else {
			
			throw new UsernameNotFoundException("User not found" + email);
			
		}
		

		return CustomUserDetails.build(user);
	}
	
}
