package org.basma.store.repositories;

import org.basma.store.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	
		UserEntity findByEmail(String email);

		UserEntity findByUserId(String userId);

}
