package com.prueba.dto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.dto.Dto.PersonasDto;
import com.prueba.dto.Entity.Personas;
import com.prueba.dto.IService.IPersonasService;
import com.prueba.dto.IRepository.IPersonasRepository;

@Service
public class PersonasService implements IPersonasService{

	@Autowired
	private IPersonasRepository repository;
	
	@Override
	public List<Personas> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Personas> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Personas save(Personas personas) {
		return repository.save(personas);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public PersonasDto login(String user, String password) {
		Personas personas= repository.findByUserAndPassword(user, password);
		PersonasDto personasDto = new PersonasDto(personas.getId(),personas.getDocumentType(),personas.getDocument(),personas.getFullName());
		return personasDto;
	}

}
