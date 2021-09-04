package my.lab.lab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

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
	 
	 @NotNull @javax.validation.constraints.NotBlank (message = "Name is mandatory") @Email(message = "Email Should be Valid")
	    private String email;
	
}
