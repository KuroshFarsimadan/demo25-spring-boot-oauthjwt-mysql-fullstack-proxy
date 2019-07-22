package ca.kuroshfarsimadan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ca.kuroshfarsimadan.model.User;
import ca.kuroshfarsimadan.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Example usage:
	 * http://localhost:8080/api/usercount?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NTEwNTM4MDMsInVzZXJfbmFtZSI6IkFsZXgxMjMiLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6ImI0MTk0YjhkLWVhOGYtNGU1Yi04YzFlLWIyZGU1NDViNmM5NCIsImNsaWVudF9pZCI6Imt1cm9zaC1jbGllbnQtdXNlcm5hbWUiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdfQ.pJeBKQU1DLNtF4Xuc7hfu-1iFtGgxISEz9y7LxPAYg4
	 * Example output: 10
	 * 
	 * @return
	 */
	@RequestMapping(value = "/usercount", method = RequestMethod.GET)
	public long countUser() {
		return userService.count();
	}

	/**
	 * Example usage:
	 * http://localhost:8080/api/user?access_token=http://localhost:8080/api/user?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NTEwNTM4MDMsInVzZXJfbmFtZSI6IkFsZXgxMjMiLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6ImI0MTk0YjhkLWVhOGYtNGU1Yi04YzFlLWIyZGU1NDViNmM5NCIsImNsaWVudF9pZCI6Imt1cm9zaC1jbGllbnQtdXNlcm5hbWUiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdfQ.pJeBKQU1DLNtF4Xuc7hfu-1iFtGgxISEz9y7LxPAYg4
	 * Example output: [ { "id": 1, "username": "Kurosh" }, { "id": 2,
	 * "username":"Farsimadan" } ]
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		userService.delete(id);
		return "success";
	}

}
