package my.lab.lab;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/adduser")
	@ApiOperation(value= "Add a new user", notes= "Email,Firstname and last name cannot be blank", response=User.class)
	public User addnewuser(@Valid @RequestBody User user) {
		
		return repo.save(user);
	}
	
	@GetMapping("/alluser")
	@ApiOperation(value= "To get all users", notes= "To find all users in DB", response=User.class)
	public java.util.List<User> allUser() {
		
		return repo.findAll();
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value= "Get User by Id", notes= "Enter ID to get the User details", response=User.class)
	public User getUserById(@PathVariable("id") Long id) {
		
		return repo.findById(id).get();
	}
	
}
