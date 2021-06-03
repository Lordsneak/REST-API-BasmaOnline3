package org.basma.store.repositories;

import org.basma.store.entities.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, Long> {
	
	//CommandeEntity findByVille(String ville);
	//CommandeEntity findByCommandeId(String commandeId);
}
