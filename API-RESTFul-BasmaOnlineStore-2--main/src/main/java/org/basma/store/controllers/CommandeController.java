package org.basma.store.controllers;

import java.util.ArrayList;
import java.util.List;

import org.basma.store.repositories.CommandeRepository;
import org.basma.store.responses.CommandeResponse;
import org.basma.store.services.CommandeService;
import org.basma.store.shared.dto.CommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commande")
public class CommandeController {

	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	CommandeService commandeService;
	
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CommandeResponse> getAllCommandes(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {

		List<CommandeResponse> commandeResponse = new ArrayList<>();

		List<CommandeDto> commandes = commandeService.getCommandes(page, limit);

		for (CommandeDto commandeDto : commandes) {
			
			CommandeResponse cmdRep = new CommandeResponse();

			BeanUtils.copyProperties(commandeDto, cmdRep);

			commandeResponse.add(cmdRep);
		}
		
		return commandeResponse;
	}
}
