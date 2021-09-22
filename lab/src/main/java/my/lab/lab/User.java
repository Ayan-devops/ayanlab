package my.lab.lab;

import java.util.HashSet;

import java.util.Set;

import javax.management.relation.Role;
import javax.validation.constraints.Email;
import javax.persistence.JoinColumn;
import javax.persistence.*;


import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	 
	 @NotNull @javax.validation.constraints.NotBlank (message = "Name is mandatory")
	    private String firstname;
	
	 public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull @javax.validation.constraints.NotBlank (message = "Name is mandatory")
    private String lastname;
	 
	 @Column (name= "email") @NotNull @javax.validation.constraints.NotBlank (message = "Name is mandatory") @Email(message = "Email Should be Valid")
	    private String email;
	 
	 @NotNull @javax.validation.constraints.NotBlank (message = "Password is mandatory") 
	    private String password;
	
     
     
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	
}
