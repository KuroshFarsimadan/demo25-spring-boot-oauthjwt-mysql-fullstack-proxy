package ca.kuroshfarsimadan.service;

import java.util.List;

import ca.kuroshfarsimadan.model.User;

// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
public interface UserService {

	// Returns the number of entities available.
	long count();

	// Deletes a given entity.
	void delete(User user);

	// Delete an entity based on id
	void delete(long id);

	// Deletes the entity with the given id. Same as above
	void deleteById(long id);

	// Deletes all entities managed by the repository.
	// void deleteAll();

	// Deletes the given entities.
	// void deleteAll(List<User> entities);

	// Returns whether an entity with the given id exists.
	boolean existsById(long id);

	// Returns all instances of the type with the given IDs.
	List<User> findAllById(List<User> ids);

	// Retrieves an entity by its id.
	User findById(long id);

	// List<User> saveAll(List<User> user);

	User save(User user);

	// Returns all instances of the type.
	List<User> findAll();

}
