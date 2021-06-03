package org.basma.store.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.basma.store.entities.CommandeEntity;
import org.basma.store.repositories.CommandeRepository;
import org.basma.store.services.CommandeService;
import org.basma.store.shared.dto.CommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements CommandeService{

	@Autowired
	CommandeRepository commandeRepository;
	
	
	@Override
	public List<CommandeDto> getCommandes(int page, int limit) {
		if(page > 0) page = page -1;
		
		List<CommandeDto> commandeDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<CommandeEntity> commandePage =	commandeRepository.findAll(pageableRequest);
		
		List<CommandeEntity> cmds = commandePage.getContent();
		
		for(CommandeEntity commandeEntity: cmds) {
			CommandeDto cmd = new CommandeDto();
			
			BeanUtils.copyProperties(commandeEntity, cmd);
			
			commandeDto.add(cmd);
		}
		return commandeDto;
	}

}
