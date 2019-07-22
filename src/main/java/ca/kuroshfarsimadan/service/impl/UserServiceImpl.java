package ca.kuroshfarsimadan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import ca.kuroshfarsimadan.dao.UserDao;
import ca.kuroshfarsimadan.model.User;
import ca.kuroshfarsimadan.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("The username or password was not valid!");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public long count() {
		return userDao.count();
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void deleteById(long id) {
		userDao.deleteById(id);
	}

	/*
	 * @Override public void deleteAll() { userDao.deleteAll(); }
	 */

	/*
	 * @Override public void deleteAll(List<User> users) { userDao.deleteAll(users);
	 * }
	 */

	@Override
	public boolean existsById(long id) {
		return userDao.existsById(id);
	}

	@Override
	public List<User> findAllById(List<User> users) {
		return userDao.findAllById(users);
	}

	@Override
	public User findById(long id) {
		return userDao.findById(id);
	}

	/*
	 * @Override public List<User> saveAll(List<User> users) { return
	 * userDao.saveAll(users); }
	 */
}
