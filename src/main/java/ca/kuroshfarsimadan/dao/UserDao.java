package ca.kuroshfarsimadan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.kuroshfarsimadan.model.User;



@Repository
// Spring Data JPA to store and retrieve data in a relational database.
public interface UserDao extends CrudRepository<User, Long> {
	/*
	 * UserDao extends the CrudRepository interface. The type of entity and ID that
	 * it works with, User and Long, are specified in the generic parameters on
	 * CrudRepository.
	 * 
	 * By extending CrudRepository, UserDao inherits several methods for working
	 * with User persistence, including methods for saving, deleting, and finding
	 * User entities.
	 * 
	 * Spring Data JPA also allows you to define other query methods by simply
	 * declaring their method signature. In the case of UserDao, this is shown with
	 * a findByUsername(String username) or findByVariableName() method.
	 */
	User findByUsername(String username);

	void deleteById(long id);

	// void deleteAll(List<User> users);

	boolean existsById(long id);

	List<User> findAllById(List<User> users);

	User findById(long id);

	// List<User> saveAll(List<User> users);
}
