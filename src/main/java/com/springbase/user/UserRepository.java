package com.springbase.user;
import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepository {
	
	Optional<User> findByEmail(String email);

	Optional<User> findById(Long userId);

	void save(User user);
	
}