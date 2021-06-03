package org.basma.store.services;

import java.util.List;

import org.basma.store.shared.dto.CommandeDto;

public interface CommandeService{

	List<CommandeDto> getCommandes(int page, int limit);
	//CommandeDto getCommandeById(String commandeId);
	
}
